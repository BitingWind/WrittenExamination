package huaweiOJ;
import java.util.*;
public class Palindrome {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String a = scan.next();
			String b = scan.next();
			int result = 0;
			for(int i = 0; i <= a.length(); i++){
				String newStr;
				if(i == 0)
					newStr = b + a;
				else if(i == a.length())
					newStr = a + b;
				else
					newStr = a.substring(0,i) + b + a.substring(i,a.length());
				if(isPalindrome(newStr)) result++;
			}
			System.out.println(result);
		}
	}
	private static boolean isPalindrome(String s){
		int i = 0;
		int j = s.length() - 1;
		while(i < j && s.charAt(i) == s.charAt(j)){
			i++;
			j--;
		}
		return i >= j;
	}
}
