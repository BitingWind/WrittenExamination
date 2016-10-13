/*
 * �����е�K�����
 * �㷨���ڿ���������зֺ���������汾��
 * �����зַ���ֵ������ֿ���������ѭ�����ң�
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
		if(lo == hi) return lo; //nextInt ������������Ϊ�������Ǹ���������ִ����bug����ǰ��Ӹ��жϣ�����������
		int r = new Random().nextInt(hi - lo) + lo; //range �����
		exch(a,lo,r);
		int c = a[lo];
		while(true){
			while(a[++i] < c) if(i == hi) break; //�� lo+1 ��ʼ
			while(a[--j] > c) if(j == lo) break; //��hi ��ʼ
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
