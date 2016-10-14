/*
 * 计算所有和为固定值的正数连续序列
 */
package array;

public class PositiveSquenceSum {
	public static void sequenceQuick(int value){
		int lo = 1;
		int hi = 2;
		int curSum = lo + hi;
		while(lo < value/2 + 1){
			if(curSum == value) print(lo,hi);
			else if(curSum > value){ //将状态转变，由大于--》小于
				while(curSum > value && lo < value/2 + 1){
					curSum -= lo;
					lo++;
					if(curSum == value) print(lo,hi);
				}
			}
			hi++; //  < or == 
			curSum += hi;
		}
	}
	//调用序列求和函数，计算重复度高，简单
	public static void sequence(int value){
		int lo = 1;
		int hi = 2;   //两个指针，通过互相自增改变和的值
		while(lo < value/2 + 1){  //边界条件lo + lo+1 = value
			int sum = sumOfseq(lo,hi);
			if(sum < value) hi++;
			else if(sum > value) lo++;
			else {
				print(lo,hi);
				hi++;
			}
		}
	}
	private static int sumOfseq(int lo,int hi){
		int result = 0;
		for(int i = lo;i <= hi;i++)
			result += i;
		return result;
	}
	private static void print(int lo,int hi){
		for(int i = lo;i <= hi;i++)
		    System.out.format("%d ",i);
		System.out.println();
	}
	public static void main(String[] args){
		sequenceQuick(15);
	}
}
