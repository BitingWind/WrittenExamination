/*
 * 大数计算，因为Integer的范围为2 * 1E10,Long为9* 1E19题目给出 E18显然结果可为int
 * 
 */
package huaweiOJ;
import java.math.*; //Big数所在包
import java.util.*;
public class Intestellar {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String numString = scan.next();
			BigInteger N = new BigInteger(numString);//字符串构造
			double num = N.doubleValue();            //Big -> Double
			int sqrt = (int)Math.floor(Math.sqrt(num)); //由其开方项向前查询，缩短时间
			int result;
			for(result = sqrt; result > 0; result--){
				double re = (double)result;
				if(re * re + re <= num) break;
			}
			System.out.println(result);
		}
	}
}
