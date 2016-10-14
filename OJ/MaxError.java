/*
 * 给出数组元素（单向）之间最大差值，
 * 即   0<= a <= b < n   Max( A[b] - A[a] )
 * 关键思想： 求每个元素的左边最小值，做差
 */
package huaweiOJ;
public class MaxError {
	public static int getDis(int[] A, int n) {
        int[] minLeft = new int[n];
        int result = 0;
        minLeft[0] = A[0]; 
        for(int i = 1; i < n; i++){
        	minLeft[i] = (minLeft[i-1] > A[i]) ? A[i] : minLeft[i-1];
        	int error = A[i] - minLeft[i];
        	if(result < error) result = error;
        }
        return result;
    }
	public static void main(String[] args){
		int[] a = new int[]{5, 4, 3, 8, 9, 7};
		System.out.println(getDis(a,a.length));
	}
	
}
