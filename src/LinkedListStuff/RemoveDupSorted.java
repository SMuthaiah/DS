package LinkedListStuff;

public class RemoveDupSorted {
	
	public ListNode deleteDuplicates(ListNode head) {
	    if(head==null||head.next==null) return head;
	    ListNode dummy=head;
	    while(dummy.next!=null){
	        if(dummy.next.val==dummy.val){
	            dummy.next=dummy.next.next;
	        }else dummy=dummy.next;
	    }
	    return head;
	}

}
