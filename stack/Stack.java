import java.util.Arrays;
import java.util.Scanner;

public class Stack{

	private int top;
	private int[] stack;

	public Stack(int tamanho){
		this.top = -1;
		this.stack = new int[tamanho];
	}
	
	public boolean isEmpty(){
		return this.top == -1;
	}

	public boolean isFull(){
		return this.top + 1 == this.stack.length;
	
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
	
	public int olhaElemento(int index){
		if (index > this.top || index < 0){
			return -1;
		}

		Stack aux = new Stack(this.stack.length);
		
		index = this.top - index;
		int i = 0;
		while (i < index){
			aux.push(this.pop());
			i += 1;
		}
		
		int res = this.stack[this.top];
		
		while (!aux.isEmpty()){
			push(aux.pop());
		}
		return res;
	}


	public String toString(){

		String res = "";

		Stack aux = new Stack(this.stack.length);

		while (!isEmpty()){
			aux.push(pop());
		}
	
		while (!aux.isEmpty()){
			int elemento = aux.pop();
			push(elemento);
			res += String.valueOf(elemento);
		}


		return res;
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

		int res = pilha.olhaElemento(i);

		if (res == -1){
			 System.out.println("indice invalido");
		} else{
			System.out.println(res);
			System.out.println(pilha.toString());
		}
        }
}
