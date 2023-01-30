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
			                 "|N: Novo lembrete\n" + 
			                 "|R: Remover lembrete\n" + 
			                 "|nº: Edita a nota correspondente\n" + 
			                 "|0: Fechar programa\n" + 
			                 " ---------------------------------\n>\u001b[0m ");
			let = sc.next().toUpperCase();
			try {
				n = Integer.parseInt(let);
				
				// em breve
				if (n != 0) {
					System.out.println("\nEM BREVE\n");
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