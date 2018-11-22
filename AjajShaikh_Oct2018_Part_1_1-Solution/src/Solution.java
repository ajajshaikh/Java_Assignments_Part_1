/*
 *	T	->	Number of test cases
 *	N	->	Number of elements in the linked list
 **/



import java.util.*;

public class Solution extends SinglyLinkedList {
	
	 public static void main(String args[]){	
		 int N,input,T;
		 Scanner s=new Scanner(System.in);
		 SinglyLinkedList l1 = new SinglyLinkedList();
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
				 head=l1.addfront(head, input);
			 else
				 head=l1.addfront(head,input);		//function call for adding element to the front (head position)
		 }
		 
		 head=l1.updateList(head,N);		//function call to update data till halfway of list			
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
	 
	
	 
}