package BinaryTreePractice;

public class PreOrderTrav {

	//Given a Binary Tree print its value in pre-order traversal (DLR). 
	
	public void printPreOrder(Node root){
		
		//Base check
		if (root==null)
			return;
		
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
		
	}
	
	//Post-order traversal (LRD)
	public void printPostOrder(Node root){
		
		if(root==null)
			return;
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.println(root.data);
		
	}
	
	//inorder traversal i.e LDR
	
	public void printInOrder(Node root){
		
		if(root==null)
			return;
		
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
		
	}
	
	
	
}
