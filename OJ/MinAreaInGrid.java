package huaweiOJ;
import java.util.*;
public class MinAreaInGrid {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			int[] x = new int[n];
			int[] y = new int[n];
			for(int i = 0; i < n; i++){
				x[i] = scan.nextInt();
				y[i] = scan.nextInt();
			}
			int deltaX = maxDelta(x);
			int deltaY = maxDelta(y);
			int max = (deltaX > deltaY) ? deltaX : deltaY;
			System.out.println(max * max);
		}
	}
	private static int maxDelta(int[] a){
		int max = a[0];
		int min = a[0];
		for(int i = 0; i < a.length; i++){
			if(max < a[i]) max = a[i];
			if(min > a[i]) min = a[i];
		}
		return max - min;
	}
}
