/*
 * Huawei WE find the number of "coder"(ignore case sensitivity) in given strings.
*/
//package huaweiOJ;
import java.util.*;
import java.util.regex.*;
public class FindCoder {
	private static final String PAT = "[cC][oO][Dd][Ee][Rr]";
	public static String[] find(String[] A,int n){
		//并行数组，一存索引，一存查找数
		int[] indexs = new int[n];
		int[] numCoders = new int[n];
		for(int i = 0; i < n; i++){
			indexs[i] = i;
			numCoders[i] = numOfCoder(A[i],"coder");
		}
		sort(numCoders,indexs);  
		int N = 0;
		//查找含“coder”个数的非零项，升序的倒置查找
		for(int i = n -1; i >=0; i--){
			if(numCoders[indexs[i]] == 0) break;
			N++;
		}
		String[] result = new String[N];
		//由后向前读取
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
	//插入排序，升序，倒置稳定性版本
	private static void sort(int[] a,int[] indexs){
		for(int i = 0; i < a.length; i++){
			for(int j = i; j >= 1 && a[j] <= a[j-1];j--){ //"<="中的= 为适应本题所加！！！！
				exch(a,j,j-1);
				exch(indexs,j,j-1);
			}	
		}
	}
	//Pattern版本,来自java库正则表达式匹配
	private static int numOfCoder(String txt){
		Pattern pat = Pattern.compile(PAT);
		Matcher m = pat.matcher(txt);
		int result = 0;
		while(m.find()) result++; 
		return result++;
	}
	//暴力子字符串查找，非显式回退版本，忽略txt的大小写
	private static int numOfCoder(String txt,String pat){
		int i, N = txt.length();
		int j, M = pat.length();
		int result = 0;
		for(i = 0; i <= N - M;i++){
			for(j = 0; j < M; j++){
				int iC = (int)txt.charAt(i + j);
				if(iC <= (int)'Z' && iC >= (int)'A') //大写 -> 小写
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
