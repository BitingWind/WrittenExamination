/*
 * ��һ������������������������У�����Ԫ��
 * ���ģ�ѡȡ���Ͻ�Ԫ�أ���������Ƚϣ�
 * ����Ԫ�ؽϴ�����ǰһ�в���
 * ����Ԫ�ؽ�С��������һ�в���
 * ֱ���������������󣬻�����С��
 */
package array;

public class SearchA2DMatrix {
	public static boolean search  (int[][] a,int value)throws RuntimeException{
		if(a.length == 0) throw new RuntimeException("the Array a is none");
		int M = a.length;
		int N = a[0].length;
		int i = 0,j = N-1;
		while(i < M && j >= 0){
			if(a[i][j] > value) j--;
			else if(a[i][j] < value) i++;
			else return true;
		}
		return false;
	}
	public static void main(String[] args){
		try{
			int[][] a = new int[][]{
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
			}; 
			//int[] b = new int[]{1,2,3};
		    System.out.println(search(a,0));
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
	}
}
