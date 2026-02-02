

public class ArrayList{

	private int tamanho;
	private int[] array;
	private static final int CAPACIDADE_DEFAULT = 20;


	public ArrayList(){
		this(CAPACIDADE_DEFAULT);
	}

	public ArrayList(int capacidade){
		this.array = new int[capacidade];
		this.tamanho = 0;
	}

	
	public boolean add(int elemento){
		asseguraCapacidade(this.tamanho + 1);		
		this.array[this.tamanho++] = elemento;
		return true;
	}

	public void add(int index, int elemento){

		if (index < 0 || index > this.tamanho) throw new IndexOutOfBoundsException();

		
		asseguraCapacidade(this.tamanho + 1);
		shiftDireita(index);
		this.array[index] = elemento;
		this.tamanho += 1;
	}


	public void set(int index, int elemento){

		if (index < 0 || index >= this.tamanho) throw new IndexOutOfBoundsException();
		this.array[index] = elemento;
	}
	
	public int remove(int index){

		if (index < 0 || index >= this.tamanho) throw new IndexOutOfBoundsException();

		int elemento = this.get(index);
		shiftEsquerda(index);

		this.tamanho -= 1;

		return elemento;
	}

	public boolean removeA(int elemento){
		for (int i = 0; i < this.tamanho; i++){

			if (this.array[i] == elemento){
				this.remove(i);
				return true;
			}
		}
		return false;
	}



	public int get(int index){

		if (index < 0 || index >= this.tamanho){
			throw new IndexOutOfBoundsException();
		}
		return this.array[index];
	}

	
	public int indexOf(int elemento){

		for (int i = 0; i < this.tamanho; i++){
			if (this.array[i] == elemento){
				return i;
			}
		}
		return -1;
	}

	public boolean contains(int elemento){
		return indexOf(elemento) != -1;
	}

	public void shiftEsquerda(int index){
		for (int i = index; i < this.tamanho -1; i++){
			this.array[i] = this.array[i+1];
		}
	}

	public void shiftDireita(int index){
		if (index == this.array.length -1){
			throw new IndexOutOfBoundsException();
		}

		for (int i = this.tamanho; i > index; i --){
			this.array[i] = this.array[i-1];
		}	
	}

	public void asseguraCapacidade(int capacidadePretendida){

		if (capacidadePretendida > this.array.length){
			resize(Math.max(capacidadePretendida, this.array.length * 2));
		}

	}

	public void resize(int novaCapacidade){

		int[] novoArray = new int[novaCapacidade];

		for (int i = 0; i<this.array.length; i++){
			novoArray[i] = this.array[i];
		}

		this.array = novoArray;
	}

	
}
