package storage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadWrite {
	private File arq = new File("src/main/java/storage/dados.txt");
	private Scanner leitor;
	private FileWriter escreve;
	
	// Leitura
	public String ler() {
		String json = "";
		
		try{
			leitor = new Scanner(arq);
		}catch(Exception e) {}
		
		if(leitor.hasNextLine()) {
			json += leitor.nextLine();
		}
		
		leitor.close();
		
		return json;
	}
	
	// Escrita
	public void escrever(String dados) {
		try{
			escreve = new FileWriter(arq);
			
			escreve.write(dados);
			escreve.close();
		} catch (Exception e){}
	}
}