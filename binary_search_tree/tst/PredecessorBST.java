import java.util.*;

public class PredecessorBST{

	private Node root;
	
	public PredecessorBST(){
		this.root = null;
	}
	public boolean isEmpty(){
		return this.root == null;
	}

	public void add(int value){
		if (isEmpty()){
			this.root = new Node(value);
		}else{
			Node aux = this.root;

			while (aux != null){
				if (aux.value > value){
					if (aux.left == null){
						Node newNode = new Node(value);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
				aux = aux.left;
				}else{
					if (aux.right == null){
						Node newNode = new Node(value);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
				aux = aux.right;
				}
			}
		}
	}

	public Node search(int value){

		Node aux = this.root;
		
		while (aux != null){
			if (aux.value == value) return aux;
			else if (value < aux.value) aux = aux.left;
			else if (value > aux.value) aux = aux.right;	
		}

		return null;
	}

	public ArrayList<Integer> getPath(Node node){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		Node toSee = search(node.value);
		
		if (toSee == null) return null;

		lista.add(toSee.value);

		if (toSee.left != null) {
			Node aux = toSee.left;
			
			while (aux != null){
				lista.add(aux.value);
				aux = aux.right;
			}
		}else{
			Node aux = toSee.parent;
			
			while (aux != null && aux.value > toSee.value){
				lista.add(aux.value);
				aux = aux.parent;
			}

			if (aux!= null) {
				lista.add(aux.value);
			}
		
		}
		return lista;
	}

class Node{

	int value;
	Node parent;
	Node left;
	Node right;

	public Node(int valor){
		this.value = valor;
	}
}

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);

	String[] ele = sc.nextLine().split(" ");

	PredecessorBST bst  = new PredecessorBST();

	for (String e : ele){
		bst.add(Integer.parseInt(e));
	}

	int alvo = sc.nextInt();

	sc.close();

	PredecessorBST.Node node = bst.new Node(alvo);
	System.out.println(bst.getPath(node));
    }
}
