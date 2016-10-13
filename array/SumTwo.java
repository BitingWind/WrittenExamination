/*
 * 对已排序的数组，采用左右夹逼法求取其和为固定值
 * 作为一个练习，对未排序的数组，采用归并排序,且用hashSet存储index值
 */
package array;
import java.util.*;
public class SumTwo {
	private static void mergeInt(int[] a,int[] aux,int lo,int mid,int hi){
		int i = lo;
		int j = mid + 1;
		for(int m=lo;m<=hi;m++)  //每次对部分归并时，均需要将原来的数组复制到辅助数组中
			aux[m] = a[m];
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(aux[i] < aux[j]) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	private static void mergeSortInt(int[] a,int[] aux,int lo,int hi){
		if(lo >= hi) return;
		int mid = (lo + hi)/2;
		mergeSortInt(a,aux,lo,mid);
		mergeSortInt(a,aux,mid+1,hi);
		mergeInt(a,aux,lo,mid,hi);
	}
	private static void sort(int[] a){
		int[] aux = new int[a.length]; //辅助数组的建立
		mergeSortInt(a,aux,0,a.length-1);
	}
	private static void search(int[] a,int value){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			map.put(a[i], i);
		}
		sort(a);
		int lo = 0, hi = a.length - 1;
		int[] result = new int[]{-1,-1};
		while(lo < hi){
			int sum = a[lo] + a[hi];
			if(sum < value) lo++;
			else if(sum > value) hi--;
			else {
				result[0] = map.get(a[lo])+1;
				result[1] = map.get(a[hi])+1;
				if(result[0] > result[1]){
					int cmp = result[0];
					result[0] = result[1];
					result[1] = cmp;
				} 
				break;
			}
		}
		if(result[0] > 0){
			System.out.print("Index1 : " + result[0] + "  Index2 : "+ result[1]);
		}
		else System.out.print("It don't have two numbers that their sum is  "+ value);
	}
	public static void main(String[] args){
		int[] a = new int[]{56,23,5,6,8,26};
	/*	sort(a);
		for(int i : a)
			System.out.print(" " +i);
			*/
		search(a,61);	
	} 
}
