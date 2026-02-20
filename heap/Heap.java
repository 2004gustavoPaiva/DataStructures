
public class Heap{

	private int[] heap;
	private int tail;
	
	public Heap(int capacidade){
		this.heap = new int[capacidade];
		this.tail = -1;
	}

	public boolean isEmpty(){
		return this.tail == -1;
	}

	public Heap(int[] heap){
		this.heap = heap;
		this.tail = this.heap.length - 1;
		this.buildHeap();
	}

	public int left(int i){
		return 2*i+1;
	}

	public int right(int i){
		return 2*(i+1);
	}

	public int parent(int i){
		return Math.floorDiv(i - 1, 2);
	}
	
	public void resize(){
		int[] aux = new int[this.heap.length * 2];

		for (int i = 0; i <= tail; i++){
			aux[i] = this.heap[i];
		}

		this.heap = aux;
	}

	public void add(int v){
		if (tail >= (heap.length-1)) 
			resize();

		tail += 1;
		this.heap[tail] = v;

		int i = tail;

		while (i > 0 && this.heap[parent(i)] < this.heap[i]){
			int aux	 = this.heap[i];
			this.heap[i] = this.heap[parent(i)];
			this.heap[parent(i)] = aux;
			i = parent(i);
		}
	}

	public int remove(){
		if (isEmpty()) throw new RuntimeException("Empty");
		
		int element = this.heap[0];
		this.heap[0] = this.heap[tail];
		
		tail -= 1;
		
		this.heapfy(0);

		return element;
	}

	private void heapfy(int index){
		if (isLeaf(index) || !isValidIndex(index)){
			return;
		}

		int index_max = max_index(index, left(index), right(index));

		if (index_max != index){
			swap(index, index_max);
			heapfy(index_max);
		}
	}

	private int max_index(int index, int left, int right){
		if (this.heap[index] > this.heap[left]){
			if (isValidIndex(right)){
				if (this.heap[right] > this.heap[index]){
					return right;
				}
			}
			return index;
		}else{
			if (isValidIndex(right)){
				if(this.heap[right] > this.heap[left]){
					return right;
				}
			}

			return left;
		}
	}

	private boolean isValidIndex(int index){
		return index >= 0 && index <= tail;
	}
	
	private boolean isLeaf(int index){
		return index > parent(tail) && index <= tail;
	}

	private void swap(int i, int j){
		int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;
	}

	private void buildHeap(){
		for (int i = parent(this.tail); i >= 0; i--){
			heapfy(i);
		}
	}

	
}	
