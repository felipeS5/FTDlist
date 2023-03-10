import java.util.Scanner;
import func.Funcoes;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Funcoes func = new Funcoes();
		
		String let;
		int n = -1;
		
		do{
			func.ver();
			System.out.print(" \u001b[96m---------------------------------\n" + 
			                 "| Oq vc vai fazer?\n" + 
			                 " ---------------------------------\n" + 
			                 "|N: Nova tarefa\n" + 
			                 "|R: Remover tarefa\n" + 
			                 "|nº: Edita a tarefa correspondente\n" + 
			                 "|0: Fechar programa\n" + 
			                 " ---------------------------------\n>\u001b[0m ");
			let = sc.next().toUpperCase();
			try {
				n = Integer.parseInt(let);
				
				if (n != 0) {
					func.edit(n);
				}
				
			}catch (NumberFormatException e) {
				if (let.equals("N")) {
					func.add();
				}else if(let.equals("R")) {
					func.remove();
				}else{
					System.out.println("\nDigite algo válido!\n");
				}
			}
			
		}while (n != 0);
		
		sc.close();
	}
}