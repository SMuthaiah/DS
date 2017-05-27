package LinkedListStuff;

public class AddNodeinCircular {
	
	//Two pointers, one slow pointer(prev) and one fast pointer(cur). 
	
	 public void add(ListNode n, ListNode head)
	  {
	     if(head.next==head)
	     {
	     	head.next = n;
	     	n.next = head;
	     	return;
	     }
	     
	     //find the right pos.
	     ListNode prev = head.next;
	     ListNode cur = head.next.next;
	     while(cur!=head && cur.val<=n.val)
	     {
	     	prev = cur;
			cur = cur.next;
	     }
	     
	     n.next = prev.next;
	     prev.next = n;
	     if(n.val<prev.val)
	     {
	        int temp = n.val;
	        n.val = prev.val;
	        prev.val = temp;
	     }     
	  }

}
