import java.util.*;

public class SomaFolhas{

	private Node root;


	public SomaFolhas(){
		this.root = null;
	}


	public boolean isEmpty(){
		return this.root == null;
	}


	public void add(int v){
		if (isEmpty()){
			this.root = new Node(v);
		}else{
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
				}else{
					if (aux.right == null) {
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

	public int cont (){
		return cont(this.root);
	}

	private int cont(Node node){
		if (!node.isLeaf() || node == null){
			return 0;
		}
		
		return 1 + cont(node.left) + cont(node.right);
	}

	public int  bfs(){
		int cont = 0;
		Deque<Node> queue = new LinkedList<Node>();

		if (!isEmpty()){
			queue.addLast(this.root);
			while (!queue.isEmpty()){
				Node current = queue.removeFirst();

				if (current.isLeaf()){
					cont += current.value;
				}

				if (current.left != null){
					queue.addLast(current.left);
				}

				if (current.right != null) {
					queue.addLast(current.right);
				}
			}
		}
		return cont;
	}

class Node{

	int value;
	Node parent;
	Node left;
	Node right;

	public Node(int v){
		this.value = v;
	}

	public boolean isLeaf(){
		return this.right == null && this.left == null;
	}
}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] elementos = sc.nextLine().split(" ");
		
		SomaFolhas bst = new SomaFolhas();
		
		for (String e : elementos){
			bst.add(Integer.parseInt(e));
		}

		System.out.println(bst.bfs());
	}
}
