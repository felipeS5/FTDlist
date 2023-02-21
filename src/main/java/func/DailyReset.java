package func;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

import storage.ReadWrite;

public class DailyReset {
	ReadWrite rw = new ReadWrite();
	JSONArray dados = new JSONArray(rw.ler());
	
	
	public DailyReset() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
	
	public void checarData() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataLocal = ldt.format(dtForm);
		String dataOld = rw.getData();
		
		if(!dataOld.equals(dataLocal)) {
			rw.setData(dataLocal);
			
			for ( int i=0; i<dados.length(); i++) {
				JSONObject obj = new JSONObject(dados.get(i).toString());
				
				if(obj.getBoolean("dReset")) {
					obj.put("estado", "A");
				}
				
				dados.put(i, obj);
				rw.escrever(dados.toString());
			}
			
			System.out.print("TAREFAS FORAM ZERADAS");
			try { Thread.sleep(2000); } catch(Exception e){}
		}
	}
	
}