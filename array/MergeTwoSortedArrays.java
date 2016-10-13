package array;

public class MergeTwoSortedArrays {
	public static int[] merge(int[] a,int m,int[] b,int n){
		int i = m-1, j = n-1;
		for(int k = m+n-1;k >= 0;k--){
			if(i < 0) a[k] = b[j--];
			else if(j < 0) a[k] = a[i--];
			else if(a[i] > b[j]) a[k] = a[i--];
			else a[k] = b[j--];
		}
		return a;
	}
	public static void main(String[] args){
		int[] a = new int[20];
		int[] b = new int[]{6,15,23,24,24};
		int[] a1 = new int[]{25,26,27,27,32};
		int[] a2 = new int[]{0,1,2,3,4};
		int[] a3 = new int[]{4,6,18,23,28,90};
		for(int i=0;i<a3.length;i++){
			a[i] = a3[i];
		}
		int[] result = merge(a,a3.length,b,b.length);
		for(int j = 0;j<result.length;j++){
			System.out.format("%d ",a[j]);
		}
	}
}
