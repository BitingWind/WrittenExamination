package huaweiOJ;
import java.util.*;
public class TwoSorted {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			ArrayList<String> s = new ArrayList<String>();
			for(int i = 0; i < n; i++){
				String s1 = scan.next();
				s.add(s1);
			}
			boolean blen = false;
			boolean blex = false;
			int l = 0;
			while(l < n-1 && s.get(l).length() < s.get(l + 1).length()) l++;
			if(l == n-1) blen = true;
			l = 0;
			while(l < n-1 && s.get(l).compareTo(s.get(l + 1)) == 1) l++;
			if(l == n-1) blex = true;
			String result;
			if(blen && blex) result = "both";
			else if(blen) result = "lengths";
			else if(blex) result = "lexicographically";
			else result = "none";
			System.out.println(blex);
		}
	}
}
