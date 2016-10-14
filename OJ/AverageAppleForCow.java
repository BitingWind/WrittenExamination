/*
 * 分苹果，每次必须从一个钟拿出两个苹果给另一个
 * 记录拿取最少次数
 */
package huaweiOJ;
import java.util.*;
public class AverageAppleForCow {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int[] apple = new int[n];
			int sum = 0;
			for(int i = 0;i < n; i++){
				int next = scan.nextInt();
				apple[i] = next;
				sum  = sum + next;
			}
			if(sum % n != 0) {
				System.out.println("-1");
				continue;
			}
			int aver = sum / n ;
			int isOdd = aver & 0x01;
			int i;
			//判断所有值与平均值的奇偶度是否一样，利用了int值的异或操作，比boolean简捷
			for(i = 0; i < n; i++){
				if((( apple[i] & 0x01 ) ^ isOdd ) != 0)
					break;
			}
			if(i < n) {
				System.out.println("-1");
				continue;
			}
			int result = 0;
			//每次操作最大与最小的数
			int lo = min(apple);
			int hi = max(apple);
			while(apple[lo] < apple[hi]){
				apple[hi] -= 2;
				apple[lo] += 2;
				lo = min(apple);
				hi = max(apple);
				
				result++;
			}
			System.out.println(result);
		}
	}
	private static int max(int[] A){
		int result = 0;
		for(int i = 0; i < A.length; i++)
			if(A[result] < A[i])
				result = i;
		return result;
	}
	private static int min(int[] A){
		int result = 0;
		for(int i = 0; i < A.length; i++)
			if(A[result] > A[i])
				result = i;
		return result;
	}
}
