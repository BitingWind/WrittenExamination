/*
 * ��������п������� 
 * input [1,2,3]
 * output[1 2 3][3 1 2][1 3 2][3 2 1][2 3 1][2 1 3]
 * Ƶ��������ɾ����Listʵ��Ӧѡ��LinkedList<> !!
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
				for(int j=0;j<=l.size();j++){   //ע�⣬���Բ��뵽�����ǰ�����
					l.add(j,numI);//����Ԫ�ز��뵽����λ��
					current.add(new ArrayList<Integer>(l));
					l.remove(j);//����Ԫ��ɾ����������һ�β�ͬ�Ĳ���
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
