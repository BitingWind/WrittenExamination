package huaweiOJ;
import java.util.*;
public class NonContinuousSubString {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			String t = scan.nextLine();
			if(t.equals("")){
				System.out.println("YES");
				continue;
			}
			int i , j = 0;
			for(i = 0; i < s.length(); i++){
				if(s.charAt(i) == t.charAt(j)){
					j++;
					if(j == t.length()) break;
				}
			}
			if(j == t.length()) System.out.println("Yes");
			else System.out.println("NO");
		}
	}
}
