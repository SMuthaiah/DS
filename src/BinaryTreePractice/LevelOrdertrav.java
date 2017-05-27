package BinaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//implement using Queue
public class LevelOrdertrav {


	public ArrayList<ArrayList<Integer>> levelOrder(Node root){
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if(root==null)
			return res;
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		ArrayList<Integer> curr = new ArrayList<Integer>();
		
		while(!q.isEmpty()){
			
			Node tmp = q.poll();
			
			if(tmp!=null){
				
				curr.add(tmp.data);
				if(tmp.left!=null)
					q.offer(tmp.left);
				if(tmp.right!=null)
					q.offer(tmp.right);
				
			}
			else{
				//end of a level, add the curr to res and return 
				ArrayList<Integer> curr_c = new ArrayList<Integer>(curr);
				res.add(curr_c);
				curr.clear();
				if(!q.isEmpty())
					q.offer(null);
				
			}
			
		}

		return res;

	}

}
