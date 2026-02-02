import java.util*;

public class Pilha{

	private int topo;
	private int[] pilha;
	
	public Pilha(int capacidade){
		this.topo = -1;
		this.pilha = new int[capacidade];
	}

	public boolean isEmpty(){
		return this.topo == -1;
	}

	public boolean isFull(){
		return this.topo == this.pilha.length -1;
	}
	
	public void push(int ele){
		if (isFull() throw new RuntimeException("PILHA CHEIA!");
		
		this.pilha[++this.topo] == ele;
	}

	public int pop(){
		if (isEmpty() throw new RuntimeException("PILHA VAZIA!");

	}

	public int peek(){
		if (isEmpty() throw new RuntimeException("PILHA VAZIA!");
		return this.pilha[this.topo];
	}
}

public class InverteSemFila{

	

	public inverte(


	public static void main(String[] args){
                Scanner sc = new Scanner(System.in);

                        int tamanho = sc.nextInt();
                        sc.nextLine();

                        String linha = sc.nextLine();


                        int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

                        Stack pilha = new Stack(tamanho);

                        for (int v : array){
                                pilha.push(v);
                        }

			

	}

}
