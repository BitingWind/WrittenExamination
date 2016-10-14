package array;

public class TimesInSortedArray {
	public static int times(int[] a,int value){
		if(a == null || a.length == 0) return 0;
		int indexlo = -1;
		int indexhi = -1;
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(a[mid] < value) lo = mid + 1;
			else if(a[mid] > value) hi = mid - 1;
			else{
				if(mid == 0 || a[mid -1] < value){
					indexlo = mid;
					break;
				}	
				else hi = mid - 1; 
			}
		}
		lo = 0;hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(a[mid] < value) lo = mid + 1;
			else if(a[mid] > value) hi = mid - 1;
			else{
				if(mid == a.length -1 || a[mid + 1] > value){
					indexhi = mid;
					break;
				}
				else lo = mid + 1; 
			}
		}
		if(indexlo == -1) return 0;
		else return indexhi - indexlo + 1;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,1,2,3,3,3,3,3,4,5,6,6,6,6};
		System.out.println(times(a,8));
	}
}
