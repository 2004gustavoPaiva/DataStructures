

public class Heap{

	
	public void add(int v){
		
		if (this.tail >= this.heap.length-1){
			resize();
		}

		tail += 1;
		this.heap[tail] = v;
	
		int i = tail;
		while (i > 0 && this.heap[parent(i)] < this.heap[i]){
			int aux = this.heap[parent(i)];
			this.heap[parent(i)] = this.heap[i];
			this.heap[i] = aux;
			i = parent(i);
		}

	}
	
}
