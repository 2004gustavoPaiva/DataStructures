import java.util.*;

public class BFSDireita{

	private Node root;

	public BFSDireita(){
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

		
	public ArrayList<Integer> bfs(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> queue = new LinkedList<Node>();

		if (!isEmpty()){
			queue.addLast(this.root);
			while(!queue.isEmpty()){
				Node current = queue.removeFirst();
				
				list.add(current.value);
				
				if (current.right != null){
					queue.addLast(current.right);
				}

				if (current.left != null){
					queue.addLast(current.left);
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
}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	
		String[] e = sc.nextLine().split(" ");

		BFSDireita bst = new BFSDireita();

		for (String i: e){
			bst.add(Integer.parseInt(i));
		}
		System.out.println(bst.bfs().toString().replace(",", "").replace("[", "").replace("]", ""));
		
		sc.close();
	}
}
