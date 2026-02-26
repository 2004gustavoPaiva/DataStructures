

public class BST2{

	private Node root;

	public boolean isEmpty(){
		return this.root == null;
	}

	public void add(int v){
		if (isEmpty()){
			this.root = new Node(v);
		}else{
			Node aux = this.root;

			while(aux!=null){
				if (v < aux.value){
					if (aux.left == null){
						Node newNode = new Node(v);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
				}else{
					if (aux.right == null){
						Node newNode = new Node(v);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
				aux = aux.right;
				}
			}
		}
	}

	public Node search(int v){
		if (isEmpty()) {
			return null;
		}

		Node aux = this.root;

		while (aux!=null){
			if (aux.value == v) return aux;
			else if (v < aux.value) aux = aux.left;
			else if (v > aux.value) aux = aux.right;
		}

		return null;
	}

	public Node max(){
		if (isEmpty()) return null;
	
		return max(this.root);
	}

	private Node max(Node node){
		if (node.right == null) return node;

		else return max(node.right);
	}

	public Node min(){
		if (isEmpty()) return null;
		
		return min(this.root);
	}

	private Node min(Node node){
		if (node.left == null) return node;
		else return min(Node node);
	}

	public Node sucessor(int v){
		if (node == null) return null;

		if (node.right != null){
			return min(node.right);
		}else{
			Node aux = node.parent;
		}

		while (aux != null && aux.value < node.value){
			aux = aux.parent;
		}

		return aux;
	}

	public Node predecessor (int v){
		if (node == null) return null;

		if (aux.left != null){
			return max(aux.left);
		}else{
			Node aux = node.parent;

			while (aux != null && aux.value >node.value{
				aux = aux.parent;	
			}
		}
	}

	public int height(){
		return height(this.root);
	}

	private int height (Node node){
		if (node == null) return -1;
		else return 1 + Math.max(height(node.left) + height(node.right))
	}

	public 


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
