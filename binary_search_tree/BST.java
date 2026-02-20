import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BST{

	private Node root;
	private int size;


	public boolean isEmpty(){
		return this.root == null;
	}

	public void add(int v){
		this.size += 1;
		if (isEmpty()){
			this.root = new Node(v);
		}
		else{
			Node aux = this.root;

			while (aux!=null){
				if (v < aux.value){
					if (aux.left == null){
						Node newNode = new Node(v);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
				}	
				else{
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


	public void recursiveAdd(int v){
		this.size += 1;
		
		if (isEmpty()){
			this.root = new Node(v);
		}else{
			recursiveAdd(this.root, v);	
		}
	}

	
	private void recursiveAdd(Node node, int v){
		
			
		if (v < node.value){
			if (node.left == null){
				Node newNode = new Node(v);
				node.left = newNode;
				newNode.parent = node;
				return;
			}
			recursiveAdd(node.left, v);
		}else{
			if (node.right == null){
				Node newNode = new Node(v);
				node.right = newNode;
				newNode.parent = node;
				return;
			}
			recursiveAdd(node.right, v);
		}
	}

	public Node search (int v){
		Node aux = this.root;
		
		while (aux!=null){
			if (v < aux.value) aux = aux.left;
			else if (v > aux.value) aux = aux.right;
			else return aux;
		}

		return null;
	}


	public Node recursiveSearch(int v){
		return recursiveSearch(this.root, v);
	}

	private Node recursiveSearch(Node node, int v){
		
		if (node == null) return null;
		else if (node.value == v) return node;
		else if (v < node.value) return recursiveSearch(node.left, v);
		else return recursiveSearch(node.right, v);
	}

	public Node min(){
		if (isEmpty()) return null;
		
		Node aux = this.root;
		
		while (aux.left != null){
			aux = aux.left;
		}
		
		return aux;
	}

	private Node min(Node node){
		Node aux = node;

		while (aux.left != null){
			aux = aux.left;
		}
	
		return aux;
	}

	public Node max(){
		if (isEmpty()) return null;

		Node aux = this.root;
		
		while (aux.right != null){
			aux = aux.right;
		}
		
		return aux;
	}

	private Node max(Node node){
		Node aux = node;

		while (aux.right != null) aux = aux.right;
		
		return aux;
	}

	public Node sucessor(Node node){
	
		if (node == null) return null;
	
		if (node.right != null){
			return min(node.right);
		}else{
			Node aux = node.parent;

			while (aux != null && aux.value < node.value){
				aux = aux.parent;
			}
			return aux;
		}
	}

	
	public Node predecessor(Node node){
		if (node == null) return null;

		if (node.left != null) return max(node.left);
		else{
			Node aux = node.parent;

			while (aux != null && aux.value > node.value){
				aux = aux.parent;
			}

			return aux;
		}
	}

	
	public int height(){
		return height(this.root);
	}

	private int height(Node node){
		if (node == null) return -1;
		else return 1 + Math.max(height(node.left), height(node.right));
	}

	public void remove(int value){
		Node toRemove = search(value);
	
		if (toRemove != null){
			remove(toRemove);
			this.size -= 1;
		}
	}

	private void remove(Node toRemove){
		
		if (toRemove.isLeaf()){
			if (toRemove == this.root){
				this.root = null;
			}
			else{
				if(toRemove.value < toRemove.parent.value){
					toRemove.parent.left = null;
				}else{
					toRemove.parent.right = null;
				}
			}
		}
		else if (toRemove.hasOnlyLeftChild()){
			if (toRemove == this.root){
				this.root = toRemove.left;
				this.root.parent = null;
			}else{
				toRemove.left.parent = toRemove.parent;
				if (toRemove.value < toRemove.parent.value){
					toRemove.parent.left = toRemove.left;
				}else
					toRemove.parent.right = toRemove.left;
			}
		}
		else if (toRemove.hasOnlyRightChild()){
			if (toRemove == this.root){
				this.root = toRemove.right;
				this.root.parent = null;
			}else{
				toRemove.right.parent = toRemove.parent;
				if (toRemove.value < toRemove.parent.value){
					toRemove.parent.left = toRemove.right;
				}else{
					toRemove.parent.right = toRemove.right; 
				}
			}
		} else{
			Node sucessor = sucessor(toRemove);
			toRemove.value = sucessor.value;
			remove(sucessor);
		}
			
	}

	
	public void preOrder(){
		preOrder(this.root);
	}
	
	private void preOrder(Node node){
		if (node != null){
			System.out.println(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}


	public void posOrder(){
		posOrder(this.root);
	}

	private void posOrder(Node node){
		if (node != null){
			posOrder(node.left);
			posOrder(node.right);
			System.out.println(node.value);
		}
	}

	
	public void inOrder(Node node){
		if (node != null){
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}

	public ArrayList<Integer> printBFS() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> queue = new LinkedList<Node>();
		
		if (!isEmpty()) {
			queue.addLast(this.root);
			while (!queue.isEmpty()){
				Node current = queue.removeFirst();
				
				list.add(current.value);

				if (current.left != null) {
					queue.addLast(current.left);
				}
				if (current.right != null) {
					queue.addLast(current.right);
				}

			}
		}

		return list;
	}

	
	
class Node{

	int value;
	Node parent;
	Node left;
	Node right;

	public Node(int value){
		this.value = value;
	}

	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}

	public boolean hasOnlyLeftChild(){
		return this.left != null && this.right == null;
	}

	public boolean hasOnlyRightChild(){
		return this.left == null && this.right != null;
	}

}

}
