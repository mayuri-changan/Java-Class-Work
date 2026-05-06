/*package com.demo.arrays;

import java.util.*;

public class ProductArray {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        // Step 1: store left (prefix) products
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: multiply with right (suffix) products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        return output;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println("Output:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}*/
	
	package com.demo.arrays;
	import java.util.*;
	public class ProductArray {
	public static int[]productExceptSelf(int[]nums){
		int n=nums.length;
		int []output=new int[n];
		output[0]=1;
		for(int i=1;i<n;i++) {
		output[i]=output[i-1]*nums[i-1];
		}
		int right=1;
		for(int i=n-1;i>=0;i--) {
			output[i]=output[i]*right;
			right=right*nums[i];
		}
		
		return output;
	}

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter size");
    	int n=sc.nextInt();
    	int []nums=new int[n];
    	System.out.println("elements");
    	for(int i=0;i<n;i++) {
    		nums[i]=sc.nextInt();
    	}
    	int []result=productExceptSelf(nums);
    	System.out.println("output");
   
    for(int val:result) {
    	System.out.println(val+" ");
    }
    	
    }
	
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
