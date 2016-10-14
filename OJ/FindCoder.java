package huaweiOJ;
import java.util.*;
import java.util.regex.*;
public class FindCoder {
	private static final String PAT = "[cC][oO][Dd][Ee][Rr]";
	public static String[] find(String[] A,int n){
		//�������飬һ��������һ�������
		int[] indexs = new int[n];
		int[] numCoders = new int[n];
		for(int i = 0; i < n; i++){
			indexs[i] = i;
			numCoders[i] = numOfCoder(A[i],"coder");
		}
		sort(numCoders,indexs);  
		int N = 0;
		//���Һ���coder�������ķ��������ĵ��ò���
		for(int i = n -1; i >=0; i--){
			if(numCoders[indexs[i]] == 0) break;
			N++;
		}
		String[] result = new String[N];
		//�ɺ���ǰ��ȡ
		for(int i = 0; i < N; i++){
			result[i] = A[indexs[n-1-i]];
		}
		return result;
	}
	private static void exch(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	//�����������򣬵����ȶ��԰汾
	private static void sort(int[] a,int[] indexs){
		for(int i = 0; i < a.length; i++){
			for(int j = i; j >= 1 && a[j] <= a[j-1];j--){ //"<="�е�= Ϊ��Ӧ�������ӣ�������
				exch(a,j,j-1);
				exch(indexs,j,j-1);
			}	
		}
	}
	//Pattern�汾,����java��������ʽƥ��
	private static int numOfCoder(String txt){
		Pattern pat = Pattern.compile(PAT);
		Matcher m = pat.matcher(txt);
		int result = 0;
		while(m.find()) result++; 
		return result++;
	}
	//�������ַ������ң�����ʽ���˰汾������txt�Ĵ�Сд
	private static int numOfCoder(String txt,String pat){
		int i, N = txt.length();
		int j, M = pat.length();
		int result = 0;
		for(i = 0; i <= N - M;i++){
			for(j = 0; j < M; j++){
				int iC = (int)txt.charAt(i + j);
				if(iC <= (int)'Z' && iC >= (int)'A') //��д -> Сд
					iC += 32;		
				if((int)pat.charAt(j) != iC) break;
			}
			if(j == M) result++;
		}
		return result;
	}
	public static void main(String[] args){
	/*	String[] s = new String[]{"coder 1230 coder","coDerxyz","xbxcoderlafrcoderyuccoderjcoderefldcodersstujcoderelcoder",
				"dvfowcoderfencoderqekcoderbtmcoderehcoderriyjdcodermocoder",
				"codernishiwo decoder","coder,coder","coDer,codEr,coder"};
		String[] s1 = find(s,s.length); 
		for(String S : s1)
			System.out.println(S);*/
		//String s1 = "coder";
		String s2 = "xbxcoderlafrcoderyuccoderjcoderefldcodersstujcoderelcoder";
		System.out.println(numOfCoder(s2));
	/*	int[] a = new int[]{0,1,2,3,4,5};
		int[] b = new int[]{3,1,0,0,1,0};
		sort(b,a);
		for(int i : a)
			System.out.print(i + " ");*/
	}
}
