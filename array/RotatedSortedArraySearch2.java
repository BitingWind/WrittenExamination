package array;

public class RotatedSortedArraySearch2 {
	public static int search(int[] a,int value){
		int lo = 0;
		int hi = a.length -1;
		while(lo<=hi){
			int mid = lo + (hi - lo)/2;
			if(a[mid] == value) return mid;
			//ǰ�벿�������ж��Ƿ��������У�ע��Ⱥŵ��ж�
			if(a[lo] < a[mid]){
				if(a[lo] <=value && value < a[mid])
					hi = mid;
				else lo = mid +1;
			}
			//��ʱ��lo--midΪ������mid--hiΪ�����ж��Ƿ����ں�벿�֣�ע��Ⱥ�
			else if(a[mid] < value && value <= a[hi])
				lo = mid + 1;
			else hi = mid;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a = new int[]{3,4,5,6,8,9,10,0,1,2};
		System.out.println(search(a,2));
	}
}
