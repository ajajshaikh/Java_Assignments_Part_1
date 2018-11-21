/*
 * T	->	Number of test cases
 * m	->	size of arr1[]
 * n	->	size of arr2[]
*/

import java.util.Scanner;
import java.util.Arrays;

public class test {
	
	 public static void main(String args[]) {
		int T,m,n;
		Scanner s= new Scanner(System.in);
		 //Getting number of test cases as input from user
		do{
			T = s.nextInt();
			if(T<1 || T>100000)
				System.out.println("Enter value >=1 and <=100000");
		}while(T < 1 || T > 100000);
		 
		
		while(T>0) {
			 //Getting size of arr1[] as input from user
			do{
				m=s.nextInt();
				if(m<1 || m>100000)
					System.out.println("Enter value >=1 and <=100000");
			}while(m < 1 || m > 100000);
			//Getting size of arr2[] as input from user
			do{
				n=s.nextInt();
				if(n<1 || n>100000)
					System.out.println("Enter value >=1 and <=100000");
			}while(n < 1 || n > 100000);	
			
			int arr1[]= new int[m];
			int arr2[]= new int[n];
			
			//Getting arr1[] as input from user
			for(int i=0;i<m;i++) {
				do{
					arr1[i]=s.nextInt();
					if(arr1[i]<0 || arr1[i]>100000)
						System.out.println("Enter value >=1 and <=100000");
				}while(arr1[i] < 0 || arr1[i] > 100000);
			}
			//Getting arr2[] as input from user
			for(int i=0;i<n;i++) {
				do{
					arr2[i]=s.nextInt();
					if(arr2[i]<0 || arr2[i]>100000)
						System.out.println("Enter value >=1 and <=100000");
				}while(arr2[i] < 0 || arr2[i] > 100000);	
			}
			
			System.out.println();
			computeResult(arr1,arr2,m,n);		//function call to compute the result
			T--;
		}
		s.close();

	}
	
	//Binary search function to find the index of first number greater than input from arr1[]
	static int binary_search(int arr[], int l, int r, int a) 
    { 
        while (l <= r) 
        { 
            int mid = (l+r) / 2;             
            if (arr[mid] <= a) 
                l = mid + 1; 
            else
                r = mid - 1;     
        } 	        
        return r;
        
    }
	
	//Function to compute the result and print on console
	static void computeResult(int arr1[],int arr2[],int m,int n) {
		Arrays.sort(arr2);		//sorting the array arr2[]
		for(int i=0;i<m;i++) {
			System.out.print((binary_search(arr2,0,n-1,arr1[i]) + 1) + " ");
		}
	 }
}