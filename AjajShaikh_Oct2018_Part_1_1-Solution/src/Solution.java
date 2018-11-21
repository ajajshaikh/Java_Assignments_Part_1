/*
 *	T	->	Number of test cases
 *	N	->	Number of elements in the linked list
 **/



import java.util.*;

public class Solution extends SinglyLinkedList {
	
	 public static void main(String args[]){	
		 int N,input,T;
		 Scanner s=new Scanner(System.in);
		 
		 //Getting number of test cases as input from user
		 do{
			 T=s.nextInt();
			 if(T<1 || T > 200)
				 System.out.println("Enter value >=1 and <=200");
		 }while(T<1 || T > 200);
		 while(T>0){
			//Getting number of elements in linked list as input from user
			 do{
				 N=s.nextInt();
				 if(N<1 || N>200)
					 System.out.println("Enter value >=1 and <=200");
			 }while(N<1 || N>200);
		 
		 Node head=null;
		 for(int i=0;i<N;i++){
			 input=s.nextInt();
			 if(i==0)
				 head=new Node(input);
			 else
				 head=addfront(head,input);		//function call for adding element to the front (head position)
		 }
		 
		 head=updateData(head,N);		//function call to update data till halfway of list			
		 Node curr=head;
		 System.out.println();			//printing the result
		 while(curr!= null){
			 System.out.print(curr.data + " ");
			 curr=curr.next;
		 }
		 T--;
		 
		 }
		 s.close();
	 }
	 
	 //Function to add new elements to the front of linklist
	 static Node addfront(Node head,int val){
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
	 static Node updateData(Node head,int size) {
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