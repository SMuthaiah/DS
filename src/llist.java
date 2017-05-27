import java.util.Hashtable;

public class llist {

	Node head;
	private Node slowPtr, fastPtr, previousSlowPtr;
	
	
	
	public void addAtEnd(Node n){
		
		if(head == null)
			head = n;
		else{
			Node x;
			x = head;
			while(x.getNext()!=null){
				x = x.getNext();
			}
			x.setNext(n);
		}	
	}
	
	
	
	
	public Node findMiddle(Node head){
		
		slowPtr = head;
		fastPtr = head;
		previousSlowPtr = head; 
		
		if(fastPtr.getNext()==null){
			System.out.println("There is only one node in the LinkedList");
			return fastPtr;
		}
		
		if(fastPtr.getNext()!=null && fastPtr.getNext().getNext() == null){
			
			System.out.println("only 2 in list");
			return slowPtr;
		}
		
		while(fastPtr.getNext()!=null && fastPtr.getNext().getNext()!=null){
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		
		return slowPtr;
		
	}
	
	public void printList(){
		
		Node ptr = head;
		
		if(head == null)
			System.out.println("nothing in ll");
		
		if(head!=null && head.getNext()==null){
			System.out.println("Just one node and value is" + head.getData());
		}
		while(ptr!=null){
			
			System.out.println("Values are" + ptr.getData());
			ptr = ptr.getNext();
		}
	}
	
public void printCharList(){
		
		Node ptr = head;
		
		if(head == null)
			System.out.println("nothing in ll");
		
		if(head!=null && head.getNext()==null){
			System.out.println("Just one node and value is" + head.getCharValue());
		}
		while(ptr!=null){
			
			System.out.println("Values are" + ptr.getCharValue());
			ptr = ptr.getNext();
		}
	}
	

	public void findNFromEnd(llist l, int n){
		
		Hashtable<Integer, Node> ht = new Hashtable<Integer, Node>();
		Node chkPtr = l.head;
		
		Integer i = 1;
		while(chkPtr!=null){
			ht.put(i, chkPtr);
			i++;
			chkPtr = chkPtr.getNext();
		}
		
		if(ht.size() < n-1){
			System.out.println("lesser number of nodes");
		}
		
		else{
			System.out.println("the node is" + "" + ht.get((ht.size() - n) + 1).getCharValue());
		}
			
	}
	
	public void using2Pointer(llist l, int n){
		
		Node tempNode = l.head;
		Node tempNthNode = l.head;
		int i = 0;
		
		while(l.head != null && l.head.getNext()!=null && i <= n){
			tempNthNode = tempNthNode.getNext();
			i++;
		}
		
		if(i>n){
			
			while(tempNthNode.getNext()!=null){
				tempNode = tempNode.getNext();
				tempNthNode = tempNthNode.getNext();
			}
			
		}
		
		
	}
	
	public static void main(String args[]){
		
		Node n = new Node(11);
		Node n1= new Node(12);
		Node n3 = new Node(13);
		
		Node n4 = new Node('m');
		Node n5 = new Node ('a');
		Node n6 = new Node ('l');
		Node n7 = new Node ('a');
		Node n8 = new Node ('y');
		Node n9 = new Node ('a');
		Node n10 = new Node ('l');
		Node n11= new Node ('a');
		Node n12 = new Node ('m');
		
		
		
		llist l1 = new llist();
		l1.addAtEnd(n);
		l1.addAtEnd(n1);
		l1.addAtEnd(n3);
		
		l1.printList();
		
		
		llist l2 = new llist();
		l2.addAtEnd(n4);
		l2.addAtEnd(n5);
		l2.addAtEnd(n6);
		l2.addAtEnd(n7);
		l2.addAtEnd(n8);
		l2.addAtEnd(n9);
		l2.addAtEnd(n10);
		l2.addAtEnd(n11);
		l2.addAtEnd(n12);
		
		l2.printCharList();
		

		System.out.println("middle value of 2nd LL is" + l2.findMiddle(l2.head).getCharValue());
		
		l2.findNFromEnd(l2, 9);
	}
	
}
