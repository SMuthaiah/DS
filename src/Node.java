
public class Node {

	private int data;
	private char charValue;
	private Node next;
	
	
	public Node(int data){
		this.data=data; 
	}
	
	public Node(char charvalue){
		this.charValue=charvalue;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public char getCharValue() {
		return charValue;
	}

	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	
	
}
	
