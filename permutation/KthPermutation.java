package permutation;
import java.util.*;
public class KthPermutation {
	public static String kthPermutation(int n,int k){
		List<Integer> num = new ArrayList<Integer>(); 
		int factories = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++){
			num.add(i);
		}
		for(int i=1;i<n;i++){
			factories = factories * i;
		}
		k--;   //kth --> index
		int x = n-1;
		
		while(x>=0){
			int index = k/factories; // k/(n-1)!
			sb.append(num.get(index));// 相除得到的是索引！！！要用get函数从list中取值
			num.remove(index);
			
			k = k % factories;
			if(x>0) factories = factories/x;
			x--;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(kthPermutation(8,5));
	}
}
