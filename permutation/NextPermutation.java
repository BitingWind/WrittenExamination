/*
 * ��ȡ��һ���ϴ����У���Ϊ�������Ϊ��С��ѭ����
 * ���裺1�����������ҵ����������indexΪi
 *      2���ٴ����������ҵ��׸���a[i]���ֵ��indexΪj
 *      3������a[i] a[j]
 *      4��i������У���ת
 */
package permutation;

import java.util.*;

public class NextPermutation{
	private static void nextPermutation(int[] a){
		int i;
		for(i=a.length-2;i>=0;i--){
			if(a[i] < a[i+1])
				break;
		}
		if(i>=0){
			int j;
			for(j=a.length-1;j>i;j--){
				if(a[j] > a[i])
					break;
			}
			exch(a,i,j);
		}
		
		//System.out.print("i = " + i + " j = "+ j);
		
		for(int k=i+1;k<=(a.length + i)/2;k++)//ע��Ⱥ�,ȷ���м�������ɽ���
			exch(a,k,a.length+i-k);
	}
	private static void exch(int[] a,int i,int j){
		int exch = a[i];
		a[i] = a[j];
		a[j] = exch;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
	//	ArrayList<Integer> a = new ArrayList<Integer>();
		String s = scan.nextLine();
		String[] aString = s.split(",");
		int[] a = new int[aString.length];
		for(int t=0;t<aString.length;t++){
			a[t] = Integer.parseInt(aString[t]);
		}
		nextPermutation(a);
		for(int i: a)
			System.out.print(i+" ");	
		scan.close();
	}
}
