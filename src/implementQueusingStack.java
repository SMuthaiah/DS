import java.util.Stack;

public class implementQueusingStack {
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public void enQueue(int data){
		s1.push(data);
	}
	
	public int deQueue(){
		
		if(!s2.isEmpty()){
			return s2.pop();
		}
		
		else{
			while(s1.isEmpty()){
				s2.add(s1.pop());
			}
		}
		return s2.pop();
	}

}
