/*
 * �Ѿ��������飬ȥ�����࣬�����������ظ�Ԫ��
 */
package array;

public class ElementUniquedArray {
	public static int uniqued(int[] a){
		if(a.length < 2) return a.length;
		int count = 2; //ǰ����Ԫ�رؿɴ��ȥ��count����Ϊ2
		for(int i=2;i<a.length;i++){
			if(a[i] != a[count - 1]|| a[i] != a[count-2])//����춵�ǰ�򲻵��ڸ�ǰһ��Ԫ�أ����ȥ
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
