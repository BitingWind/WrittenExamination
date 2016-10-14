package huaweiOJ;
import java.util.*;
public class PokerCompare {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			Scanner scan1 = new Scanner(scan.nextLine());
			scan1.useDelimiter("-");
			String pokersA = scan1.next();
			String pokersB = scan1.next();
			printLargerPoker(pokersA,pokersB); 
		}
	}
	private static void stringToArray(String A,int[] a){
		Scanner s1 = new Scanner(A);
		while(s1.hasNext()){
			String poker = s1.next();
			if(poker.length() == 1){
				int num = (int)poker.charAt(0);
				if(num <= (int)'9' && num >= '3')
					a[num]++;
			}
			switch(poker){
				case "J" : a[11]++; break;
				case "Q" : a[12]++; break;
				case "K" : a[13]++; break;
				case "A" : a[14]++; break;
				case "2" : a[15]++; break;
				case "10" : a[10]++; break;
				case "joker" : a[0]++; break;
				case "JOKER" : a[1]++; break;
			}
		}
		s1.close();
	}
	private static int compare(int[] a,int[] b){
		return 0;
	}
	private static void printLargerPoker(String A,String B){
		int[] pokerA = new int[17];
		int[] pokerB = new int[17];
		stringToArray(A,pokerA);
		stringToArray(B,pokerB);
		int i = compare(pokerA,pokerB);
		if(i == 1)
			System.out.println(A);
		else if(i == -1)
			System.out.println(B);
		else System.out.println("ERROR");
	}
}
