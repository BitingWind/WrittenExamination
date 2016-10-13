/*
 * 数组的所有可能排列 
 * input [1,2,3]
 * output[1 2 3][3 1 2][1 3 2][3 2 1][2 3 1][2 1 3]
 * 频繁插入与删除，List实现应选择LinkedList<> !!
 */
package permutation;
import java.util.*;
public class Permutations {
	public static ArrayList<ArrayList<Integer>> permuations(List<Integer> nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for(int numI : nums){
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> l: result){
				for(int j=0;j<=l.size();j++){   //注意，可以插入到变的最前与最后
					l.add(j,numI);//将新元素插入到任意位置
					current.add(new ArrayList<Integer>(l));
					l.remove(j);//将该元素删除，进行下一次不同的插入
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}
	public static void main(String[] args){
		int size =permuations(Arrays.asList(1,2,3,4)).size();
		System.out.println(size);
		
		for(ArrayList<Integer> arr : permuations(Arrays.asList(1,2,3,4))){
			//System.out.println(arr.size());
			for(int i : arr){
				System.out.print(i);
			}
			System.out.print(" ");
		}
	}
}
