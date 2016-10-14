/*
 * 本解法不考虑数值为负的情况！！
 */
package dynamicPrograming;
import java.util.*;
public class SelectKOnNWithInterD {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int[] value = new int[n];
			for(int i = 0; i < n; i++)
				value[i] = scan.nextInt();
			int k = scan.nextInt();
			int d = scan.nextInt();
			//第一步，找寻最大值！！！ 
			int max = 0,index = 0;
			for(int j = 0;j < n;j++)
				if(value[j] > max) {
					max = value[j];
					index = j;
				}
			//建立两个左右index
			int result = max; 
			int right = index;
			int left = index;
			//根据前值，一个个的选取下一个最大值加入到乘积中
			for(int i = 2; i <= k; i++){
				int curMax;
				int maxLeft = -1,maxRight = -1;
				int indexLeft = left - 1;
				int indexRight = right + 1;
				//左右两方面，delta为D的区间内，综合挑选最大值
				for(int m = left-1 ;m >= 0 && m > left - 1 - d; m--)
					if(value[m] > maxLeft){
						maxLeft = value[m];
						indexLeft = m;
					}
				for(int m = right + 1; m < n && m < right + 1 + d; m++)
					if(value[m] > maxRight){
						maxRight = value[m];
						indexRight = m;
				}
				//选取最大值，并更新left OR right 索引   ！!!
				//update the index range
				if(maxRight > maxLeft){
					right = indexRight;
					curMax = maxRight;
				}
				else {
					left = indexLeft;
					curMax = maxLeft;
				}
				result = result * curMax;
			}
			System.out.println(result);
		}
	}
}
