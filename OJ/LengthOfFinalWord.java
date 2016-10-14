package huaweiOJ;
import java.util.*;
public class LengthOfFinalWord {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			int N = s.length();
			int first = -1; //识别倒数第一个字母
			int result = 0; //结果
			for(int i = N-1; i >= 0; i--){
				int first1 =  (int)s.charAt(i);
				if(first == -1){
					if(first1 >= (int)'A' && first1 <= (int)'z'){
						first = first1;
						result++; //first one
					}	
				}
				else{
					if(first1 != (int)' ') //累加
						result++;
					else break;
				}
			}
			System.out.println(result);
		}
	}
}
