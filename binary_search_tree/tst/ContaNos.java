import java.util.*;

public class ContaNos{
	
	private Node root;
	
	public ContaNos(){
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
			
			while (aux != null){
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
	
	public int cont(){
		return contarInternos(this.root);
	}

	private int contarInternos(Node node) {
       	 	if (node == null || node.isLeaf()) {
            		return 0; 
        	}
        	return 1 + contarInternos(node.left) + contarInternos(node.right);
    	}



class Node{

	int value;
	Node parent;
	Node right;
	Node left;
	
	public Node(int value){
		this.value = value;
	}

	public boolean isLeaf(){
		return this.right == null && this.left == null;
	}
}

	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] elementos = sc.nextLine().split(" ");
		
		ContaNos bst = new ContaNos();
		
		for (String e: elementos){
			bst.add(Integer.parseInt(e));
		}

		sc.close();

		System.out.println(bst.cont());

		
	}
}
