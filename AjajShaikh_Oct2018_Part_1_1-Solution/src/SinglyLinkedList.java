import java.util.Stack;

//import SinglyLinkedList.Node;

public class SinglyLinkedList 
{ 
	Node head;  // head of list 

    public class Node { 
        int data; 
        Node next; 
        public Node(int d)  { // Constructor
        	data = d;  
        	next=null; 
        }  
    } 
    
    //Function to add new elements to the front of linklist
	 public Node addfront(Node head,int val){
	    	if(head==null){				//if linklist is empty then create linklist
	    		head=new Node(val);
	 	    }
	    	else{
	    		Node temp=new Node(val);
	    		temp.next=head;
	    		head=temp;
	    	}
	    	return head;
	    }
	 
	 //function to update data till halfway of the list
	 //new data of ith node = current data of ith node - data of (size-i)th node
	 public Node updateList(Node head,int size) {
		 Node temp=head;
		 Stack<Integer> stack = new Stack<Integer>();	//Stack for storing the linklist in order to get elements in reverse order
		 
		 for(int i=0;i<size;i++){
		 	stack.push(temp.data);		//pushing elements in stack
		 	temp=temp.next;
		 }
		 temp=head;
		 for(int i=0;i<size/2;i++){		//popping elements in reverse order
		 	int val=stack.pop();
		 	temp.data=temp.data - val;
		 	temp=temp.next;
		 }
		 return head;
	 }
   
}