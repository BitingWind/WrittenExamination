package array;

public class SpecificSumInSorted {
	public static void twoSum(int[] a,int value,int[] result){
		if(a == null || a.length < 2) return;
		if(value < 0) return;
		if(result == null || result.length < 2)return;
		int i = 0;
		int j = a.length -1;
		while(i < j){
			int sum = a[i] + a[j];
			if(sum < value) i++;
			else if(sum > value)j--;
			else{
				result[0] = i;
				result[1] = j;
				return;
			}
		}
		result[0] = result[1] = -1;
		return;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,4,6,8,21,23};
		int[] re = new int[]{-1,-1};
		twoSum(a,25,re);
		System.out.println(a[re[0]]);
		System.out.println(a[re[1]]);
	}
}
