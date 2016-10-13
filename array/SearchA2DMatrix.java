/*
 * 在一个左右升序，上下升序的数组中，查找元素
 * 核心：选取右上角元素，与查找数比较，
 * 若该元素较大，则向前一列查找
 * 若该元素较小，则向下一行查找
 * 直至数组结束（行最大，或列最小）
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
