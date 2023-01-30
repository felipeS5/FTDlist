package func;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import storage.Dados;
import storage.ReadWrite;

public class Funcoes {
	private Scanner sc = new Scanner(System.in);
	private List<Dados> lista = new ArrayList<>();
	private ReadWrite rw = new ReadWrite();
	
	public Funcoes() {
		lista = rw.ler(lista);
	}
	
	// Adiciona
	public void add() {
		limpaTela();
		System.out.print("\n\u001b[96mInsira a tarefa:\n>\u001b[0m ");
		lista.add(new Dados(sc.nextLine()));
		salvar();
	}
	
	// Remoção
	public void remove() {
		if (lista.size() > 0) {
			System.out.print("\u001b[96mQual tarefa deve ser removida?\n>\u001b[0m ");
			try{
				lista.remove(sc.nextInt());
				salvar();
				sc.nextLine();
			}catch (IndexOutOfBoundsException e) {
				System.out.println("\n\u001b[43m\u001b[30mEsta tarefa não existe!\u001b[0m\n");
				sc.nextLine();
				remove();
			}catch (InputMismatchException e) {
				System.out.println("\n\u001b[43m\u001b[30mDigite apenas números!!!\u001b[0m\n");
				sc.nextLine();
				remove();
			}
		}else{
			System.out.println("\n\u001b[43m\u001b[30mA lista já está vazia!!\u001b[0m\n");
			try{ Thread.sleep(3500); }catch(Exception e){}
		}
	}
	
	public void salvar() {
		rw.escrever(lista);
	}
	
	// Visualização
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