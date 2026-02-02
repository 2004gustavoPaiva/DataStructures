import java.util.*;

public class Fila{

	private int head;
	private int tail;
	private int size;
	private int[] fila;

	public Fila(int tamanho){
		
		this.fila = new int[tamanho];
		this.size = 0;
		this.head = -1;
		this.tail = -1;

	}


	public boolean isFull(){
		return this.tail == this.fila.length - 1;
	}

	public boolean isEmpty(){
		return this.tail == -1;
	}

	public void addLast(int elemento){

		if (isFull()) throw new RuntimeException("Fila cheia");
		
		if (isEmpty()) this.head = 0;

		this.fila[++this.tail] = elemento;
		this.tail += 1;
	}
	
	public void removeFirst(){
		if (isEmpty()) throw new RuntimeException("Fila vazia!");	
		this.tail -= 1;
		shiftLeft();
	}
	public void shiftLeft(){
		for (int i = this.head; i < this.tail -1; i++){
			this.fila[i] = this.fila[i+1];
		}
	}


	public String toString(){

		String out = "";
	
	
		for (int i = 0; i <this.size; i++){
			out += this.fila[i];

			if (i < this.size - 1){

				out += ", ";
			}
		}

		return out;
	}

	public int peek(){
		return this.fila[head];
	}

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

        int capacidade = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha caso venha depois do número

        Fila fila = new Fila(capacidade);

        while (true) {
            String comando = sc.next();

            if (comando.equals("end")) break;

            switch (comando) {
                case "add": {
                    int valor = sc.nextInt();
                    boolean ok = fila.add(valor);
                    if (!ok) {
                        System.out.println("full");
                    }
                    break;
                }

                case "remove": {
                    Integer removido = fila.remove();
                    if (removido == null) {
                        System.out.println("empty");
                    }
                    break;
                }

                case "element": {
                    Integer elemento = fila.element();
                    if (elemento == null)
                        System.out.println("empty");
                    else
                        System.out.println(elemento);
                    break;
                }

                case "print": {
                    if (fila.size() == 0)
                        System.out.println("empty");
                    else
                        System.out.println(fila.toString());
                    break;
                }
            }
        }

        sc.close();
    }

}
