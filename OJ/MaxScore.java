package huaweiOJ;
import java.util.*;
public class MaxScore {
	public static void main(String[] args){
		Scanner scan  = new Scanner(System.in);
		scan.useDelimiter(" ");
		while(scan.hasNextLine()){
			int N = scan.nextInt();
			int M = scan.nextInt();
			int[] score = new int[N+1];
			for(int i = 0; i < N; i++)
				score[i+1] = scan.nextInt();
			for(int i = 0; i < M; i++){
				String sql = scan.next();
				int lo = Integer.parseInt(scan.next());
				int hi = Integer.parseInt(scan.next());
				if(sql.equals("Q")){
					int max;             //排除特殊情况：输入查询时，第一个数字大于第二个数字 ！！！！
                    if(lo < hi)
                        max = max(score,lo,hi);
                    else max = max(score,hi,lo);
					System.out.println(score[max]);
				}
				else if(sql.equals("U")){
					score[lo] = hi;
				}
			}
		}
	}
	private static int max(int[] a,int lo,int hi){
		int max = lo;
		for(int i = lo; i <= hi; i++){
			if(a[max] < a[i])
				max = i;
		}
		return max;
	}
}
