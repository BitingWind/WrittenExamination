package array;

public class Fibonacci {
	//指数复杂度，不可用！！！
	public static long fibonacci(long n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static long fibonacciFast(long n){
		long[] preBuffer = new long[]{0,1};
		if(n < 2) return preBuffer[(int)n];
		long result = 0;
		for(long i = 2;i <= n;i++){
			result = preBuffer[0] + preBuffer[1];
			preBuffer[0] = preBuffer[1];
			preBuffer[1] = result;	
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(fibonacciFast(3));
	}
	
}
