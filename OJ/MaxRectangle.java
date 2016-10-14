package huaweiOJ;

public class MaxRectangle {
	public static int counArea(int[] A,int n){
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = 0;
		right[n - 1] = n - 1;
		for(int i = 1; i < n; i++){
			if(A[i] > A[i - 1])
				left[i] = i;
			else{
				int k = i;
				while(k-- > 0){
					if(A[k] < A[i]){
						left[i] = k + 1;
						break;
					}
					else{
						k = left[k];
					}
				}
				if(k == -1) left[i] = 0;
			}
		}
		for(int i = n - 2; i >= 0; i--){
			if(A[i] > A[i+1]) 
				right[i] = i;
			else{
				int k = i;
				while(k++ < n - 1){
					if(A[k] < A[i]){
						right[i] = k - 1;
						break;
					}
					else{
						k = right[k];
					}
				}
				if(k == n) right[i] = n - 1;
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++){
			int cur = A[i] * (right[i] - left[i] + 1);
			if(cur > result) result = cur;
		}
		return result;
	}
	public static void main(String[] args){
		int[] a = new int[]{7,4,8,5,2,7};
		System.out.println(counArea(a,5));
	}
}
