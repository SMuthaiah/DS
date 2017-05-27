
public class BinaryTreeNode {
	
	int data;
	BinaryTreeNode leftNode,rightNode;
	
	BinaryTreeNode(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public BinaryTreeNode getLeftNode(){
		return this.leftNode;
	}
	
	public BinaryTreeNode getRightNode(){
		return this.rightNode;
	}
	
	public void setLeftNode(BinaryTreeNode Node){
		this.leftNode = Node;
	}

	public void setRightNode(BinaryTreeNode Node){
		this.rightNode = Node;
	}
}


