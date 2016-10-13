/*
 * 已经有序数组，去除多余，最多包含两个重复元素
 */
package array;

public class ElementUniquedArray {
	public static int uniqued(int[] a){
		if(a.length < 2) return a.length;
		int count = 2; //前两个元素必可存进去，count至少为2
		for(int i=2;i<a.length;i++){
			if(a[i] != a[count - 1]|| a[i] != a[count-2])//不等於当前或不等于更前一个元素，存进去
				a[count++] = a[i];
		} 
		return count;
	}
	public static void main(String[] args){
		int[] a = new int[]{3,3,3,3,4,5,6,6,6,7,8,8,8,9,9,9,12,13};
		int length = uniqued(a);
		for(int x=0;x<length;x++)
		   System.out.println(a[x]);
	}
}
