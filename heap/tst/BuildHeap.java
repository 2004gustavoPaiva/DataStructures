import java.util.*;

public class BuildHeap{

	private int[] heap;
	private int tail;

	public BuildHeap(int[] heap){
		this.heap = heap;
		this.tail = this.heap.length -1;
		buildheap();
	}

	public int left(int i){
		return 2*i+1;	
	}
	
	public int right(int i){
		return 2*(i+1);
	}
	
	public int parent(int i){
		return Math.floorDiv(i-1, 2);
	}

	private void heapfy(int index){
		if (isleaf(index) || !isvalidindex(index))
			return;

		int index_max = max_index(index, left(index), right(index));

		if (index != index_max){
			swap(index, index_max);
			heapfy(index_max);	
		}
	}

	private boolean isleaf(int i){
		return parent(this.tail) < i && i<=this.tail;
	}

	private boolean isvalidindex(int i){
		return i>=0 && i<=tail;
	}

	private int max_index(int index, int left, int right){
		if (this.heap[index] > this.heap[left]){
			if (isvalidindex(right)){
				if (this.heap[index] < this.heap[right])
					return right;
			}
			return index;
		}else{
			if (isvalidindex(right)){
				if (this.heap[right] > this.heap[left])
					return right;
			}
			return left;
		}
	}

	private void swap(int i, int j){
		int aux = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = aux;
	}

	private void buildheap(){
		for (int i = parent(this.tail); i>=0; i--){
			heapfy(i);
		}	
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] elementos = sc.nextLine().split(" ");
		
		int[] arrayEle = new int[elementos.length];
		
		int [] aux = new int[elementos.length];
	
		for (int i = 0; i < elementos.length; i++){
			arrayEle[i] = Integer.parseInt(elementos[i]);
			aux[i] = Integer.parseInt(elementos[i]);
		}

		BuildHeap heap = new BuildHeap(arrayEle);
			
		boolean isHeap = true;
		for (int i = 0; i < arrayEle.length; i++){
			if (aux[i] != arrayEle[i]) isHeap = false;
		}

		System.out.println(isHeap);
	}

}
