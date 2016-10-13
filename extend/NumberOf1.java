package extend;

public class NumberOf1 {
	public static int number(int n){
		int count = 0;
		int move = 1;
		while(move != 0){
			if((n & move) != 0)
				count++;
			move = move << 1;
		}
		return count;
	}
	public static int numberFast(int n){
		int count = 0;
		while(n != 0){
			n = n & (n-1);
			count++;
		}
		return count;
	}
	public static void main(String[] args){
		int n = Integer.MIN_VALUE;
		System.out.format("number : %d binary £º%s number of 1 : %d", 
							n,Integer.toBinaryString(n),numberFast(n)
							);
		
	}
}
