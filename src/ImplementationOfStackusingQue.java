import java.util.Queue;
import java.util.*;

public class ImplementationOfStackusingQue {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	public void push(int data){
		q1.add(data);
	}
	
	public int pop(){
		
		while(q1.isEmpty()){
			int a = q1.poll();
		
			
		}
		return 0;
	}
	
	
	public void pop() {
	    while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top);
	    }
	    q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
	

}
