package huaweiOJ;
import java.util.*;
public class Fishing {
	public static void main(String[] args){
		Scanner  scan = new Scanner(System.in);
		int num = 0;
		while(scan.hasNext()){
			int n = scan.nextInt();
			int m = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int t = scan.nextInt();
			double probilitySum = 0.0;
			double ccPro = 0.0; 
			double ssPro = 0.0;
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= m; j++){
					double probility = scan.nextDouble();
					if(i == x && j == y) 
						ccPro = probility;
					probilitySum += probility;
				}
			ssPro = probilitySum / n / m;
			String resultStr = "equal";
			double resultPro = ccPro;
			if(ccPro > ssPro){
				resultStr = "cc";
			}
			else if(ccPro < ssPro){
				resultStr = "ss";
				resultPro = ssPro;
			}
			System.out.println(resultStr);
			System.out.format("%.2f\n",resultPro);
		//	scan.nextDouble();
		//	System.out.println(++num);
		}
	}
}
