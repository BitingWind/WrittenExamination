/*
 * netease 2017 Internal recommendation WrittenExamination
*/
package huaweiOJ;
import java.util.*;
public class CakesInGrid {
	public static void main(String[] args){
		Scanner scan  = new Scanner(System.in);
		while(scan.hasNextInt()){
			int H = scan.nextInt();
			int W = scan.nextInt();
			int[][] ab = new int[][]{
				{1, 2, 4},
				{2, 4, 4},
				{4, 4, 5}
			};
			int a = H % 4;
			int x = H / 4;
			int b = W % 4;
			int y = W / 4;
			int result = 0;
			result = x * 4 * y * 4 / 2;
			result += 2 * x * b;
			result += 2 * y * a;
			if(a != 0 && b != 0)
				result += ab[a-1][b-1];
			System.out.println(result);
		}
	}
}
