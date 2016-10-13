package sort;

public class AgeSort {
	public static void sort(int[] ages){
		int R = 101;
		int[] count = new int[R];
		for(int i=0; i<R;i++){
			count[i] = 0;
		}
		for(int i=0;i<ages.length;i++){
			count[ages[i]]++;
		}
		for(int i=0;i<R-1;i++){
			count[i+1] += count[i];
		}
		int[] aux = new int[ages.length];
		for(int i=0;i<ages.length;i++){
			aux[count[ages[i]-1]++] = ages[i];
		}
		for(int i=0;i<ages.length;i++)
			ages[i] = aux[i];
	}
	public static void main(String[] args){
		int[] ages = new int[]{25,85,85,23,46,98,46,12,25,46,46,23};
		sort(ages);
		for(int a :ages)
			System.out.print(" "+a);
	}
}
