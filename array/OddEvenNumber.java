/*
 * 将数组元素中，奇数放在偶数前面
 * 类似快速排序中的切分操作，将数组分成两部分
 * 前半部分和后半部分，满足相斥条件
 * 这样可以，建立两个索引，相遇前搜索相反条件，进行交换！！！
 */
package array;

public class OddEvenNumber {
	public static void oddEven(int[] a){
		if(a == null) return;
		int N = a.length;
		int i = 0;
		int j = N-1;
		while(i < j){
			while(!isEven(a[i])&& i < j) i++;
			while(isEven(a[j])&& j > i) j--;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
	private static boolean isEven(int n){
		return (n & 0x1) == 0;
	}
	public static void main(String[] args){
		int[] nums = new int[]{5,4,3,1,0};
		oddEven(nums);
		for(int n : nums)
			System.out.print(n+ " ");
	}
}
