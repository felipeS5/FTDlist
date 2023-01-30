package storage;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class ReadWrite {
	private File arq = new File("src/main/java/storage/dados.txt");
	private Scanner leitor;
	private FileWriter escreve;
	
	// Leitura
	public List ler(List lista) {
		
		try{
			leitor = new Scanner(arq);
		}catch(Exception e) {}
		
		while (leitor.hasNextLine()) {
			lista.add(leitor.nextLine());
		}
		
		leitor.close();
		
		return lista;
	}
	
	// Escrita
	public void escrever(List lista) {
		try{
			escreve = new FileWriter(arq);
			String dados = "";
			for ( int i=0; i<lista.size(); i++) {
				dados += lista.get(i) + "\n";
			}
			
			escreve.write(dados);
			escreve.close();
		} catch (Exception e){}
	}
}