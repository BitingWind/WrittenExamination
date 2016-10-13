/*
 * 数组中第K大的数
 * 算法基于快速排序的切分函数（随机版本）
 * 根据切分返回值将数组分开，并进行循环查找！
 */
package array;

import java.util.Random;

public class KthMax {
	public static int kth(int[] a,int k)throws IllegalArgumentException{
		if(a == null || a.length == 0)throw 
	    new IllegalArgumentException("Array is null or empty");
		if(k <= 0 || k > a.length)throw 
		    new IllegalArgumentException("K should locate in [1," + a.length+"]");
		int index = partition(a,0,a.length - 1);
		while(index != k - 1){
			if(index < k - 1) 
				index = partition(a,index + 1,a.length - 1);
			else index = partition(a,0,index -1);
		}
		return a[index];
	}
	private static int partition(int[] a,int lo,int hi){
		int i = lo,j = hi + 1;
		if(lo == hi) return lo; //nextInt 函数参数必须为正，这是个会随机出现错误的bug，在前面加个判断，可消除！！
		int r = new Random().nextInt(hi - lo) + lo; //range 随机化
		exch(a,lo,r);
		int c = a[lo];
		while(true){
			while(a[++i] < c) if(i == hi) break; //由 lo+1 开始
			while(a[--j] > c) if(j == lo) break; //由hi 开始
			if(i >= j)break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private static void exch(int[] a,int i,int j){
		int temp = a[i]; 
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args){
		int[] a = new int[]{4,7,2,1,3,5,6};
		System.out.println(kth(a,7));
	}
}
