/*
 * ���������У���ȡ����������еĳ���
 * Ҫ��O(n)������������O(nlogn)��
 * ��map���洢����ֵ�������ԣ��ڱ���һ�Σ�����ÿ��δ�����ҹ���Ԫ��
 * ����չ���������
 */
package array;

import java.util.*;

public class LongestConsecutiveSequence {
	public static int search(int[] a){
		int N = a.length;
		int longest = 1;
		//put() and get() O(C) complexity
		Map<Integer, Boolean> nums = new HashMap<Integer,Boolean>(N);
		for(int i : a)
			nums.put(i, true);
		for(int i : a){
			if(!nums.get(i)) continue;
			int j = 1;
			//��������i�����ҷ�չ��������i����������������ѭ���ļӼ������뱾��
			int m = i, n = i; 
			//��������һ���ж���++n���ұػ�ִ�У��ڶ���������ʹ��++n�������жϲ�һ��
			while(nums.get(++n) != null && nums.get(n) == true){
				j++;
				nums.put(i,false);
			} 
			while(nums.get(--m) != null && nums.get(m) == true){
				j++;
				nums.put(i,false);
			} 
			if(j > longest) longest = j;
		}
		return longest;
	}
	public static void main(String[] args){
		int[] a = new int[]{6,5,7,3,4,8};
		System.out.println(search(a));
	}
}
