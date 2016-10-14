/*
 * һ����������Ԫ�س���һ�Σ��������������Σ�����singleԪ��
 * ����˼�룺�������Ĵ����ԣ�������ͬ�������Ϊ��
 * ͨ��������Ԫ��������򣬿��������һ����singleԪ�ء�
 * ���������ָoffer��num40
 */
package array;

public class SingleNumber {
	public static void single(int[] a,int[] result){
		if(a == null || a.length < 2) return;
		int resultOR = 0;
		for(int i : a)
			resultOR ^= i;
		int indexIs1 = find(resultOR);
		for(int i: a){
			if(is1(i,indexIs1))
				result[0] ^= i;
			else result[1] ^= i;
		}
			
	}
	private static int find(int num){
		int result = 0;
		while((num & 0x1) == 0 && result < 32){
			num = num >> 1;
			result++;
		}
		return result;
	}
	private static boolean is1(int num,int index){
		num = num >> index;
		return (num & 0x01) == 1;
	}
	public static void main(String[] args){
		int[] a = new int[]{2,3,5,4,6,5,3,2};
		int[] re = new int[]{0,0};
		single(a,re);
		System.out.println(re[0]);
		System.out.println(re[1]);
	}
}
