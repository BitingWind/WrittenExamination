/*
 * 在旋转之后的有序数组中查找指定元素，
 * 对问题归约，找出两个有序部分，分别进行二分查找
 */
package array;

public class RotatedSortedArraySearch {
	public static int search(int[] a,int value){
		if(a.length == 0) return -1;
		int max;
		for(max = 0;max<a.length;max++){
			if(a[max]>a[(max+1)%a.length]) //注意边界循环部分
				break;
		}
		int m = search(a,0,max,value);
		int n = search(a,max,a.length-1,value);
		if(m >= 0) return m;
		else if(n >= 0) return n+max; //注意返回值
		else return -1;
		//return max;
	}
	private static int search(int[] a,int lo,int hi,int value){
		if(lo>hi) return -1;
		while(lo<=hi){
			int mid = lo + (hi-lo)/2;
			if(a[mid] < value) lo = mid + 1;
			else if(a[mid] > value) hi = mid -1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a = new int[]{3,4,5,6,8,9,10,0,1,2};
		System.out.println(search(a,10));
	}
}
