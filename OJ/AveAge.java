package huaweiOJ;
import java.util.*;
public class AveAge {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int W = scan.nextInt();
			int Y = scan.nextInt();
			double x = scan.nextDouble();
			int N = scan.nextInt();
			double result = Y;
			for(int i = 0; i < N; i++){
				result = (1 - x) * result + 20 * x + 1;
			}
			System.out.println((int)Math.ceil(result));
		}
	}
}
