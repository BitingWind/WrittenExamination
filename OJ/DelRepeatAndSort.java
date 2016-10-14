package huaweiOJ;
import java.util.*;
public class DelRepeatAndSort {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int N = scan.nextInt();
			boolean[] a = new boolean[1001];//0 - 1000的数字，有为true，否为false
			for(int i = 0; i <= 1000; i++)
				a[i] = false;
			for(int i = 0; i < N; i++){
				int num = scan.nextInt();
				a[num] = true;
			}
			for(int i = 0; i <= 1000; i++){
				if(a[i]) System.out.println(i);
			}
		}
	}
}
