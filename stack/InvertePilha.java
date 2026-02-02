import java.util.Scanner;
import java.util.Arrays;

public class InvertePilha{


	private int topo;
	private int[] pilha;

	public InvertePilha(int capacidade){
		this.topo = -1;
		this.pilha = new int[capacidade];
	}

	
	public boolean isEmpty(){
		return this.topo == -1;
	}

	public boolean isFull(){
		return this.topo == this.pilha.length - 1;
	}


	public void push(int ele){
		if (isFull()) throw new RuntimeException("a pilha está cheia!");
		this.pilha[++this.topo] = ele;
	}
	
	public int pop(){
		if (isEmpty()) throw new RuntimeException("a prilha está vazia!");
		return this.pilha[this.topo--];
	}

	public int peek(){
		if (isEmpty()) throw new RuntimeException("a pilha está vazia");
		return this.pilha[this.topo];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
			
			int tamanho = sc.nextInt();
       	 		sc.nextLine();  			

			String linha = sc.nextLine();
			

			int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

			InvertePilha pilha = new InvertePilha(tamanho);

			for (int v : array){
				pilha.push(v);
			}

			InvertePilha aux = new InvertePilha(tamanho);

			while(!pilha.isEmpty()){
				aux.push(pilha.pop());
			}

			while (!aux.isEmpty()){
				int ele = aux.pop();
				pilha.push(ele);
				System.out.println(ele);
			}
		}
}
