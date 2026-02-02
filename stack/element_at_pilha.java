import java.utils.Arrays;
import java.utils.Scanner;

public class Stack{

	private int top;
	private int[] stack;

	public Stack(int tamanho){
		this.top = -1;
		this.stack = new int[tamanho];
	}
	
	public boolean isEmpty(){
		return this.topo == -1;
	}

	public boolean isFull(){
		return this.topo + 1 == this.pilha.length;
	
	}

	public void push(int element){
		if (isFull()) throw new RuntimeException("Pilha cheia!");
		this.stack[++this.top] = element;
	}

	public int pop(){
		if (isEmpty()) throw new RuntimeException("Pilha vazia!!");
		return this.stack[this.top--];
	}

	public int peek(){
		if (isEmpty()) throw new RuntimeException("Pilha vazia!");
		return this.stack[this.top];
	}
	
	public int olhaElemento(int ele){
		if (isEmpty()) throw new RunitmeException("indice invalido");
		
		Stack aux = new Stack(this.stack.length);
		
		int i = 0;
		while (this.stack.peek() != ele){
			aux.push(this.stack.pop());
			i += 1;
		}

		return this.stack[(this.stack.length -1) - i];

	}
}


	public static void main(String[] args){
                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

		int i = sc.nextInt();

		Stack pilha = new Stack(array.length);

		for (int v : array){
			pilha.push(v);
		}

                System.out.println(pilha.olhaElemento(i));

        }

