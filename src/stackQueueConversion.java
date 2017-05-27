import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class stackQueueConversion {

	//Implementing a Queue with Two stacks 
	
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> s1 = new Stack<Integer>();
	
	public void enQueue(int a){	
		s.push(a);
	}
	
	public int deQueue(){
		
		if(!s1.isEmpty()){
			int a = s1.pop();
			return a;
		}
		else{
			while(s.empty()){
				s1.push(s.pop());				
			}	
			
		}
		
		return s1.pop();
		
	}	
	
	//Implementing a stack with two Queue. 
	
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> q1 = new LinkedList<Integer>();
	
	public void push(int data){
		
		q.offer(data);
		
	}
	
	public int pop(){
		
		if(!q1.isEmpty()){
			q1.clear();
			int i = q.size();
			for(int y=0;y<i;y++){
				q1.offer(q.poll());
			}
		}
		return q.poll();
	}
}
