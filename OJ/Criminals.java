package huaweiOJ;
import java.util.*;
public class Criminals {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			int t = scan.nextInt();
			int c = scan.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = scan.nextInt();
			}
			int begin = 0;
			int crimeValue = 0;
			for(int i = 0; i < c; i++)
				crimeValue += a[i];
			int result = 0;
			if(crimeValue <= t) result++;
			for(int i = 0; i < n - i; i++){
				crimeValue += a[i + c];
				crimeValue -= a[i];
				if(crimeValue <= t) result++;
			}
			System.out.println(result);
		}
	}
}
