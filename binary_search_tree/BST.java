

public class BST{

	Node root;


	public boolean isEmpty(){
		return this.root == null;
	}

	public void add(int element){
		if (isEmpty()){
			this.root = new Node(element);
		}
		else {
			Node aux = this.root;

			while (aux != null){
				if (element < aux.value){
					if (aux.left == null){
						Node newNode = new Node(element);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
	
				}

				else{
					if (aux.right == null){
						Node newNode = new Node(element);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					} 
					
					aux = aux.right;
				}
			}
		}
		}
		
		public void recursiveAdd(int element){
			if (isEmpty()){ 
				this.root = new Node(element);
			}
			else{
				recursiveAdd(this.root, element);	
			}
		}


		private void recursiveAdd(Node node, int element){
			
			if (element < node.value){
				if (node.left == null){
					Node newNode = new Node(element);
					node.left = newNode;
					newNode.parent = node.left;
					return;
				}
			
			recursiveAdd(node.left, element);
			}
			else {
				if (node.right == null){
					Node newNode = new Node(element);
					node.left = newNode;
					newNode.parent = node;
					return;
				}
			
			recursiveAdd(node.right, element);
			}
		}
		
		public Node search(int element){
			Node aux = this.root;

			while (aux != null){
				if (aux.value == element) return aux;
				if (element < aux.value) aux = aux.left;
				if (element > aux.value) aux = aux.right;
			}

			return null;
		}

		public Node recursiveSearch(int element){
			return recursiveSearch(this.root, element);
		}

		private Node recursiveSearch(Node node, int element){
			if (node == null) return null;

			if (element == node.value) return node;
			if (element < node.value) return recursiveSearch(node.left, element);
			else return recursiveSearch(node.right, element);
		}

		public Node recursiveMax(){
			if(isEmpty()) return null;
			return max(this.root);
		}

		private Node max(Node node){
			if (node.right == null) return node;
			else return max(node.right);
		}

		public Node max(){
			if (isEmpty()) return null;

			Node node = this.root;
			while (node != null){
				node = node.right;
			}

			return node;
		}

		public Node min(){
			if (isEmpty()) return null;
			else return min(this.root);
		}

		private Node min(Node node){
			if (node.left == null) return node;
			else return min(node.right);
		}

class Node{

	int value;
	Node parent;
	Node left;
	Node right;

	public Node(int v){
	
		this.value = v;
	
	}

}

}
