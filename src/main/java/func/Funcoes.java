package func;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.TimeZone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import storage.ReadWrite;

public class Funcoes {
	private Scanner sc = new Scanner(System.in);
	private ReadWrite rw = new ReadWrite();
	private JSONArray dados;
	
	public Funcoes() {
		String lista = rw.ler();
		dados = new JSONArray(lista);
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
	
	// Adiciona
	public void add() {
		JSONObject obj = new JSONObject();
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		String horaFormatada = ldt.format(dtForm);
		
		limpaTela();
		System.out.print("\n\u001b[96mInsira a tarefa:\n>\u001b[0m ");
		obj.put("tarefa", sc.nextLine());
		obj.put("estado", "A");
		obj.put("time", horaFormatada);
		dados.put(obj);
		salvar();
	}
	
	// Remoção
	public void remove() {
		if (dados.length() > 0) {
			System.out.print("\u001b[96mQual tarefa deve ser removida?\n>\u001b[0m ");
			int id;
			try{
				id = sc.nextInt();
				sc.nextLine();
				if (id<1 || id>dados.length()) {
					System.out.println("\n\u001b[43m\u001b[30mEsta tarefa não existe!\u001b[0m\n");
					remove();
				}

				dados.remove(id-1);
				salvar();				
			}catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("\n\u001b[43m\u001b[30mDigite apenas números!\u001b[0m\n");
				remove();
			}

		}else{
			System.out.println("\n\u001b[43m\u001b[30mA lista já está vazia!!\u001b[0m\n");
			try{ Thread.sleep(3500); }catch(Exception e){}
		}
	}
	
	// Salvar
	public void salvar() {
		rw.escrever(dados.toString());
	}
	
	// Visualização
	public void ver() {
		limpaTela();
		System.out.println("Tarefas:\n");
		for(int i=0; i<dados.length(); i++) {
			ver1(i, false);
		}
	}
	
	// Edição
	public void edit(int x) {
		if (0<x && x<=dados.length()) {
			limpaTela();
			ver1(x-1, true);
			System.out.print(" \u001b[96m---------------------------------\n" + 
			                 "| Oq vc vai fazer na tarefa " + x + "?\n" + 
			                 " ---------------------------------\n" + 
			                 "|V: Missão cumprida!\n" + 
			                 "|F: Missão falhou!\n" + 
			                 "|A: Em andamento\n" + 
			                 " ---------------------------------\n>\u001b[0m ");
			String let = sc.next().toUpperCase();
			String estado = "";
			
			if (let.equals("V")) {
				estado = "V";
			}else if (let.equals("F")) {
				estado = "X";
			}else if (let.equals("A")) {
				estado = "A";
			}else{
				while ((!estado.equals("V") && !estado.equals("F")) && !estado.equals("A")) {
					System.out.print("\n\u001b[43m\u001b[30mDigite algo válido!\u001b[0m\n\n>");
					estado = sc.next().toUpperCase();
				}
			}
			
			JSONObject obj = new JSONObject(dados.get(x-1).toString());
			
			obj.put("estado", estado);
			dados.put(x-1, obj);
			salvar();
		}else{
			System.out.println("\n\u001b[43m\u001b[30m Esta tarefa("+x+") não existe! \u001b[0m\n");
			try{ Thread.sleep(3500); }catch(Exception e){}
		}
	}
	
	// Ver individualmente
	public void ver1(int x, boolean tempo) {
		JSONObject obj = new JSONObject(dados.get(x).toString());
		String tarefa = obj.getString("tarefa");
		String estado = obj.getString("estado");
		String symb = "<???>";
		String cor = "<???>";
		
		if(estado.equals("A")) {
			symb = "⚪";
			cor = "\u001b[7m";
		}else if(estado.equals("V")) {
			symb = "✅";
			cor = "\u001b[42m\u001b[30m";
		}else{
			symb = "❌";
			cor = "\u001b[41m";
		}
		
		System.out.printf("%d|%s %s %s \u001b[0m\n\n", (x+1), symb, cor, tarefa);
		
		if(tempo) {
			System.out.println(obj.getString("time") + "\n");
		}
	}
	
	
	public void limpaTela() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}