package array;

public class MaxSumOfSequence {
	public static int max(int[] a) throws IllegalArgumentException{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException("Array is NULL!!!");
		int sum = 0,result = Integer.MIN_VALUE;
		for(int i:a){
			if(sum <= 0) sum = i;
			else  sum += i;
			if(sum > result) result = sum;
		}
		return result;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,-2,3,10,-4,7,2,-5};
		System.out.println(max(a));
	}
}

