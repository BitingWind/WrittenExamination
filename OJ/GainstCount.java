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
				isG[num] = false; //�����Ļָ���������important����
			}
		}
		//������ĿҪ��ӦΪ�����ܵĶ��ɳ���ȥ�ֿ����������ǰ�����Ȼ���������սʿ������Ŀ�꣬
		//�˺�������������ڼ���
	//	if(result == 0){ //�������ֿ�������Ѳ����ã�������һ��
	//		result = count(isG,S,n+1,N);
	//	}
		return result;
		
	}
}
