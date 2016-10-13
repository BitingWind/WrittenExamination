package linkedlist;

import java.util.*; 

public class SequenceOfPop {
	public static boolean isSequence(int[] pushA,int[] popA){
		if(pushA == null || popA == null) return false;
		if(pushA.length != popA.length) return false;
		Stack<Integer> s = new Stack<Integer>();
		
		int j = 0;
	    for(int i = 0;i < pushA.length;i++){
	    	s.push(pushA[i]);
	    	while(!s.isEmpty() && s.peek() == popA[j]){
	    		s.pop();
	    		j++;
	    	}
	    }
	    if(s.isEmpty()) return true;
	    else return false;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5};
		int[] b = new int[]{4,5,3,2,1};
		int[] c = new int[]{5,4,3,2,1};
		int[] d = new int[]{1,2,3,4,5};
		int[] e = new int[]{4,3,5,1,2};
		int[] f = new int[]{4,5,3,1,2};
		System.out.println(isSequence(a,f));
	}
}
