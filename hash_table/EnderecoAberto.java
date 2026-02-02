import java.util.*;

public class EnderecoAberto{

	public static class Pair{
		
		int chave;
		String valor;

		public Pair (int chave, String valor){
			this.chave = chave;
			this.valor = valor;
		}

		public Pair(){
			this.chave = Integer.MIN_VALUE;
		}

	}

	private Pair[] tabela;
	private static final int TAMANHO_DEFAULT = 11;
	private int size;
	private static final Pair APAGADO = new Pair();

	public EnderecoAberto(int capacidade){
		this.tabela = new Pair[capacidade];
	}

	public EnderecoAberto(){
		this.tabela = new Pair[TAMANHO_DEFAULT];
	}

	public Integer hash(int chave){
		return chave % this.tabela.length;
	}

	public void put(int chave, String value){
		int hash = hash(chave);
		int salvo = hash;

		int probing = 0;
		int idxApagado = -1;
		while (this.tabela[hash] != null && probing < this.tabela.length){
			if (this.tabela[hash].chave == chave){
				this.tabela[hash].valor = value;
				return;
			}

			if (this.tabela[hash].equals(APAGADO) && idxApagado == -1) idxApagado = hash;
			
			probing++;
			hash = (salvo + probing) % this.tabela.length;
		}
		
		if (isFull()) return;

		if (idxApagado != -1) tabela[idxApagado] = new Pair(chave, value);
		else tabela[hash] = new Pair(chave, value);

		this.size++;
	}

	public Pair remove(int chave){
		int hash = hash(chave);
		int salvo = hash;

		int probing = 0;
		Pair res = tabela[hash];
		while (tabela[hash] != null && probing < tabela.length){
			if (tabela[hash].chave == chave){
				res =tabela[hash];
				tabela[hash] = APAGADO;
				this.size--;
				break;
			}

			probing++;
			hash = (salvo + probing) % tabela.length;
		}
		
		return res;	
	}

	public boolean isFull(){
		return this.size == this.tabela.length;
	}

}
