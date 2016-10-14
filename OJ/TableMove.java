/*
 * 此题重点考察由double运算后所得的结果极度接近整数的，原则上若是整数运算的结果就是整数
 * 不能简单的进行ceil();因为ceil()是不安全的，而对floor()的结果进行判断在选择是否加1，就是安全的。
 */
package huaweiOJ;
import java.util.*;
public class TableMove {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			float r = scan.nextInt();
			float x = scan.nextInt();
			float y = scan.nextInt();
			float x1 = scan.nextInt();
			float y1 = scan.nextInt();
			double dist = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
			double result = dist / 2 / r;
			int resultFloor = (int)Math.floor(result);
			if(result - resultFloor > 1E-6)
				resultFloor += 1;
		//	System.out.println((int)(Math.ceil(result)));
			System.out.println(result);
		}
	}
}
