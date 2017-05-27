import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {

	BinaryTreeNode rootNode;
	
	BinaryTree(BinaryTreeNode node){
		this.rootNode = node;
	}
	
	public void printPreOrder(BinaryTreeNode rootNode){
		//Doing it by recurssion
		
		if(rootNode!=null){
		System.out.println(rootNode.getData());
		printPreOrder(rootNode.getLeftNode());
		printPreOrder(rootNode.getRightNode());
		}
	}
	
	public ArrayList<Integer> preOrderNR(BinaryTreeNode rootNode){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		
		if(rootNode!=null){
			
			s.push(rootNode);
			
			while(!s.isEmpty()){
				
				BinaryTreeNode temp = s.pop();
				result.add(temp.getData());
				
				if(temp.rightNode!=null){
					s.push(temp.rightNode);
				}
				
				if(temp.leftNode!=null){
					s.push(temp.leftNode);
				}	
			}
		}
	
				
		return result;	
	}
		
	
	public void inOrderRecurssion(BinaryTreeNode node){
		
		if(node!=null){
		
		inOrderRecurssion(node.getLeftNode());
		System.out.println(node.getData());
		inOrderRecurssion(node.getRightNode());
		}
		
	}
	
	public ArrayList<Integer> inOrderNormal(BinaryTreeNode node){
		
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode = node;
		boolean done = false;

		while(!done){
			if(currentNode!=null){
				s.push(currentNode);
				currentNode = currentNode.getLeftNode();
			}
			else
			{
				if(s.isEmpty()){
					done = true;
				}
				else{
					currentNode = s.pop();
					result.add(currentNode.getRightNode().getData());
					currentNode = currentNode.getRightNode();
				}
				
			}
				
			BinaryTreeNode temp = s.pop();		
		}	
		return result;
	}
	
}
