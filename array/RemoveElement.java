package array;

public class RemoveElement {
	public static int remove(int[] a,int value){
		int index = 0;
		for(int i=0;i<a.length;i++){
			if(a[i] != value)
				a[index++] = a[i];
		}
		return index;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,2,2,6,7,8,9,2};
		int index = remove(a,2);
		for(int i=0;i<index;i++)
			System.out.print(a[i]+" ");
	}
}
