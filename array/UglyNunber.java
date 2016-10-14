package array;

public class UglyNunber {
	public static int number(int ith) throws IllegalArgumentException{
		if(ith <= 0) 
			throw new IllegalArgumentException("The Argument should be larger than 0 !!!");
		int[] uglys = new int[ith];
		uglys[0] = 1;
		int index2 = 0,index3 = 0,index5 = 0;
		int nextIndex = 1;
		while(nextIndex < ith){
			int next = min(uglys[index2] * 2,uglys[index3] * 3,uglys[index5] * 5);
			uglys[nextIndex] = next;
			while(uglys[index2] * 2 <= next) index2++;
			while(uglys[index3] * 3 <= next) index3++;
			while(uglys[index5] * 5 <= next) index5++;
			nextIndex++;
		}
		return uglys[nextIndex - 1];
	}
	public static int number2(int ith) throws IllegalArgumentException{
		if(ith <= 0) 
			throw new IllegalArgumentException("The Argument should be larger than 0 !!!");
		int result = 0;
		int index = 0;
		while(true){
			if(isUgly(result++)){
				index++;
				if(index == ith)
					return result - 1;
			}
		}
	}
	private static boolean isUgly(int value){
		if(value <= 0) return false;
		while(value % 2 == 0) value = value / 2;
		while(value % 3 == 0) value = value / 3;
		while(value % 5 == 0) value = value / 5;
		return value == 1;
	}
	private static int min(int i,int j,int k){
		int min = i;
		if(j < min) min = j;
		if(k < min) min = k;
		return min;
	}
	public static void main(String[] args){
		//for(int i = 1;i <= 2;i++)
			System.out.print(number2(20)+ " ");
	}
}
