package storage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadWrite {
	private File arq = new File("src/main/java/storage/dados.txt");
	private File date = new File("src/main/java/storage/date.txt");
	private Scanner leitor;
	private FileWriter escreve;
	
	// Leitura
	public String ler() {
		try{
			leitor = new Scanner(arq);
		}catch(Exception e) {}
		
		String json = leitor.nextLine();
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
	
	// DATE
	//Leitura
	public String getData() {
		try{
			leitor = new Scanner(date);
		}catch(Exception e) {}
		
		String json = leitor.nextLine();
		leitor.close();
		
		return json;
	}
	
	// Escrita
	public void setData(String dt) {
		try{
			escreve = new FileWriter(date);
			
			escreve.write(dt);
			escreve.close();
		} catch (Exception e){}
	}
}