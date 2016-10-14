package huaweiOJ;
import java.util.*;
public class GainstCount {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int N = scan.nextInt();
			ArrayList<Integer>[] S = (ArrayList<Integer>[])(new ArrayList[6]);
			for(int i = 0; i < N; i++){
				S[i] = new ArrayList<Integer>();
				String s = scan.next();
				for(int j = 0; j < s.length(); j++){
					S[i].add((int)s.charAt(j) - (int)'0' );
				}
			}
			boolean[] isG = new boolean[6];
			int result = 0;
			result = count(isG,S,0,N);
			System.out.println(result);
		}
	}
	private static  int count(boolean[] isG,ArrayList<Integer>[] S,int n,int N){
		if(n >= N) return 1;
		int result = 0;
		for(int num : S[n]){
			if(isG[num]) continue;
			else{
				isG[num] = true;
				result += count(isG,S,n+1,N);
				isG[num] = false; //条件的恢复！！！！important！！
			}
		}
		//根据题目要求，应为尽可能的多派出人去抵抗，所以如果前面的已然包括后面狂战士的所有目标，
		//此后面项及其后所有项不在计算
	//	if(result == 0){ //本次所抵抗对象均已不可用，跳到下一次
	//		result = count(isG,S,n+1,N);
	//	}
		return result;
		
	}
}
