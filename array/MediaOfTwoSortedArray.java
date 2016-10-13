/*
 * 指定两个有序数组，给出其中位数（若总数为奇数，返回中间数，否则返回两个中间数之平均值）
 * 问题归约为 归并两个有序数组的归并问题！！！！
 */
package array;

public class MediaOfTwoSortedArray {
	public static double search(int[] a,int[] b){
		int sum = a.length + b.length;
		if(sum % 2 != 0)  //判断数组长度和是否为奇数
			return search(a,b,sum/2+1);
		else{
			double media = (double)(search(a,b,sum/2)+search(a,b,sum/2+1)); 
			return media/2;
		}
	}
	public static int search(int[] a,int[] b,int kth){
		int i = 0, M = a.length;
		int j = 0, N = b.length;
		if(kth > N+M) return -1;
		int k;
		boolean isA = true; //判断最后所需的归并元素是否来自 a 数组
		for(k = 0;k < kth;k++){  
			int lastI = i;  
			if(i == M) j++;
			else if(j == N)i++;
			else if(a[i] < b[j])i++;
			else j++;
			if(lastI != i)isA = true;  //判断是否来自 a
			else isA = false;
		}
		if(isA) return a[i-1];  //注意 -1
		else return b[j-1];
	}
	public static void main(String[] args){
		int[] a = new int[]{3,4,5,6,8,7,9,10};
		int[] b = new int[]{0,2};
		System.out.println((a.length+b.length)/2);
		System.out.println(search(a,b));
	}
}
