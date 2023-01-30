package func;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import storage.Dados;

public class Funcoes {
	private Scanner sc = new Scanner(System.in);
	private List<Dados> lista = new ArrayList<>();
	
	public void add() {
		limpaTela();
		System.out.print("\n\u001b[96mInsira a tarefa:\n>\u001b[0m ");
		lista.add(new Dados(sc.nextLine()));
	}
	
	public void remove() {
		System.out.print("\u001b[96mQual tarefa deve ser removida?\n>\u001b[0m ");
		try{
			lista.remove(sc.nextInt());
		}catch (IndexOutOfBoundsException e) {
			System.out.print("Esta tarefa não existe!");
		}catch (/*InputMismatch*/Exception e) {
			System.out.print("Digite apenas números!!!");
		}
	}
	
	public void ver() {
		limpaTela();
		System.out.println("Tarefas:\n");
		
		for(int i=0; i<lista.size(); i++) {
			System.out.println(i+1 + "- " + lista.get(i) + "\n");
		}
	}
	
	public void limpaTela() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}