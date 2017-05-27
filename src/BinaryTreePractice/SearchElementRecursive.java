package BinaryTreePractice;

public class SearchElementRecursive {
	
	
	public boolean searchinBT(Node root, int a){
		
		if(root == null)
			return false;
		
		if(root.data == a){
			return true;
		}
		
		return (searchinBT(root.left,a)||searchinBT(root.right,a));
	
	}
	
}
