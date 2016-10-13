/*
 * 查找数组中最小的K个数
 * 依赖切分函数实现，
 * 在进行中依赖切分函数对数组的改变。
 */
package array;

import java.util.*;

public class KMinNumber {
	public static int[] kMin(int[] a,int k) throws IllegalArgumentException{
		int[] result = new int[k];
		try{
			KthMax.kth(a, k);
		}catch(IllegalArgumentException e){
			throw e;
		}
		for(int i = 0;i < k;i++)
			result[i] = a[i];
		return result;
	}
	//若要允许重复值，则set不可用！！！！需使用数组排序或者优先堆来解决！！！
	public static TreeSet<Integer> kMin2(int[] a,int k)throws IllegalArgumentException {
		if(a == null || a.length == 0)throw 
	    new IllegalArgumentException("Array is null or empty");
		if(k <= 0 || k > a.length)throw 
		    new IllegalArgumentException("K should locate in [1," + a.length+"]");
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i: a){
			if(set.size() < k) set.add(i);
			else if(i < set.last()){
				set.remove(set.last());
				set.add(i);
			}
		}
		return set;		
	}
	public static void main(String[] args){
		int[] a = new int[]{2,2,2,1,3,5,7};
		for(int i : kMin2(a,6))
			System.out.println(i);
	}
}
