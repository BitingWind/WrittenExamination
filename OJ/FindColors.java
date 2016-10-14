package huaweiOJ;
import java.util.*;
public class FindColors {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			int max = 0;
			int[] colorsNum = new int[n];
			//找到最大值
			for(int i = 0; i < n; i++){
				int num = scan.nextInt();
				colorsNum[i] = num;
				if(max < num){
					max = num;
				}
			}
			int ceil = 1;
			//最大值的位数 max < 2^num
			int num;
			for( num = 1; num < 32; num++){
				ceil = ceil *2;
				if(max < ceil) break;
			}
			//判断所有数的每一位是否非零，若均为零，不需要该位的颜料
			boolean[] location = new boolean[num];
			for(int i = 0; i < num; i++){
				for(int j : colorsNum){
					if(location[i])break;
					//判断第i位是否为1！！！
					if(!((j & 0x01 << i) ==0))
						location[i] = true;
				}
			}
			//统计非零位的个数
			int result = 0; 
			for(boolean bool : location)
				if(bool) result++;
			//若上述混合方法所需大于直接按号买取，则换直接买的方法
			if(result > n)
				result = n;
			System.out.println(result);
		}
	}
}
