/*
 * ������Ԫ���У���������ż��ǰ��
 * ���ƿ��������е��зֲ�����������ֳ�������
 * ǰ�벿�ֺͺ�벿�֣������������
 * �������ԣ�������������������ǰ�����෴���������н���������
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
