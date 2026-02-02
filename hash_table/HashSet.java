import java.util.*;

public class HashSet{

	private Integer[] tabela;


	public HashSet(int tamanho){
		this.tabela = new Integer[tamanho];
	}


	public boolean contains(Integer chave){
		int sondagem = 0;
		int hash;

		while (sondagem < tabela.length){

			hash = (hash(chave) + sondagem) % this.tabela.length;


			if (tabela[hash] == null) return false;
			if (tabela[hash].equals(chave)) return true;

			sondagem += 1;
		}
		return false;
	}


	public Integer hash(int chave){
		return chave % this.tabela.length;
	}
	
	public void put(int chave){
		int sondagem = 0;
		int hash;

		while (sondagem < this.tabela.length){

		hash = (this.hash(chave) + sondagem) % this.tabela.length;
			
			if (this.tabela[hash] == null || this.tabela[hash].equals(Integer.MIN_VALUE)|| this.tabela[hash].equals(chave)){
				this.tabela[hash] = chave;
				return;
			}
			sondagem += 1;
		}

	}


	public Integer remove(Integer chave){
		int sondagem = 0;
		int hash;

		int tamanho = this.tabela.length;
		while (sondagem < tamanho){	
			hash = (hash(chave) + sondagem) % tamanho;
			if (tabela[hash] == null) return null;
			if (this.tabela[hash].equals(chave)){

				int elemento = this.tabela[hash];
				this.tabela[hash] = Integer.MIN_VALUE;
				return elemento;
			}
			
			sondagem += 1;
		}
		return null;
	}

public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for (int i = 0; i < tabela.length; i++) {
        if (tabela[i] == null) {
            sb.append("null");
        } else if (tabela[i] == Integer.MIN_VALUE) {
            sb.append("null"); 
        } else {
            sb.append(tabela[i]);
        }

        if (i < tabela.length - 1) sb.append(", ");
    }

    sb.append("]");
    return sb.toString();
}



	public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	
	int tamanho = sc.nextInt();
	
	HashSet tabela = new HashSet(tamanho);

	String ope = "";

	String[] operacoes = ope.split(" ");

	while (!ope.equals("end")){

		ope = sc.nextLine();

		operacoes = ope.split(" ");

		switch (operacoes[0]){

			case "put":
				tabela.put(Integer.parseInt(operacoes[1]));
				System.out.println(tabela.toString());
				break;
			case "remove":
				tabela.remove(Integer.parseInt(operacoes[1]));
				System.out.println(tabela.toString());
				break;
			case "contains":
				System.out.println(tabela.contains(Integer.parseInt(operacoes[1])));
				break;
		}

	}

	}

}
