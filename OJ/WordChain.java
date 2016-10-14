package huaweiOJ;
import java.util.*;
public class WordChain {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			LinkedList<String> words = new LinkedList<String>();
			for(int i = 0; i < n; i++)
				words.add(scan.next());
			boolean result = false;	
			Iterator<String> iter0 = words.iterator();
			while(true){
				if(!iter0.hasNext()){
					if(words.size() == 1) result = true;
					break;
				}else{
					boolean getTail = false;
					String first = iter0.next();
					String cur = first;
					while(!getTail){
						getTail = true;
						Iterator<String> iter = words.iterator();
						while(iter.hasNext()){
							String s = iter.next();
							if(cur.charAt(cur.length() - 1) == s.charAt(0)){
								cur = s;
								iter.remove();
								getTail = false;
								break;
							}
						}		
					}
					first = first.substring(0,1) + cur.substring(cur.length() - 1);
				}
					
			}
			if(result)System.out.println("Yes");
			else System.out.println("No");
		}
	}
	
}
