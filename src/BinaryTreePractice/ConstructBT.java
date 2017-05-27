package BinaryTreePractice;

public class ConstructBT {

	Node root;
	int MinHD;
	int MaxHD; 
	int HD = 0; 
	
	//Utility function to find the Min and Max HD of a Binary tree. 
	
	public void findMinMax(Node node, int MinHD, int MaxHD, int HD){
		
		if(node == null)
			return;
		
		//Update the Min and Max 
		if(HD<MinHD)
			MinHD = HD;
		if(HD>MaxHD)
			MaxHD = HD;
		
		//recur for left and right subtrees
		findMinMax(node.left, MinHD, MaxHD, HD-1);
		findMinMax(node.right, MinHD, MaxHD, HD+1);
		
	}
	
	
	//Utility function to print the range
	public void printTheNodeVertically(int line_num, int HD, Node n){
		
		if(n == null)
			return;
		
		if(line_num == HD)
			System.out.println(n.data + " ");
		
		printTheNodeVertically(line_num,HD-1,n.left);
		printTheNodeVertically(line_num,HD+1,n.right);
		
	}
	
	
	
	//Function to print the Tree Vertically. 
	
	public void VerticalTraversal(Node root){
		
		findMinMax(root, MinHD, MaxHD, HD);
		
		for(int line_num = MinHD;line_num <= MaxHD;line_num++){
			
			printTheNodeVertically(line_num,HD,root);
			
		}
		
		
	}
	
	
	public static void main (String args[]){
		
	ConstructBT BT = new ConstructBT();
	PreOrderTrav trav = new PreOrderTrav();
	
	BT.root = new Node(1);
	BT.root.left = new Node(2);
	BT.root.left.left = new Node(4);
	BT.root.left.right = new Node(5);
	BT.root.right = new Node(3);
	BT.root.right.left = new Node(6);
	BT.root.right.right = new Node(7);
	BT.root.right.left.right = new Node(8);
	BT.root.right.right.right = new Node(9);
	
	System.out.println("Pre-Order");
	trav.printPreOrder(BT.root);
	System.out.println("");
	System.out.println("Post-Order");
	trav.printPostOrder(BT.root);
	System.out.println("");
	System.out.println("In-Order");
	trav.printInOrder(BT.root);
		
	
	}
	
	
	
	
	
	
}
