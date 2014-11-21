
public class Node {

	private Node head;
	private int data;
	private Node next;
	
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	// to find whether linked list even or odd
	public boolean isEven(Node head)
	{
		boolean flag = true ;
		Node temp = head;
		while(temp.next!=null)
		{
			flag = !flag;
			temp = temp.next;
		}
		if(flag)
			return false;
		else
			return true;
	}
	
	// to find whether linked list even or odd using recursion
	public boolean isEvenRec(Node head)
	{
		if(head == null){
			return false;
		}
		else if (head.next== null)
			return true;
		else
			return isEvenRec(head.next);
	}
	
	
}
