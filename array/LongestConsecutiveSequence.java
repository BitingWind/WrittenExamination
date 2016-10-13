/*
 * 无序数组中，获取最长连续数序列的长度
 * 要求O(n)，不可用排序（O(nlogn)）
 * 用map，存储数组值及其属性，在遍历一次，依据每个未被查找过的元素
 * 左右展开，计算最长
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
			//！！！由i向左右发展，不能用i来做索引，那样会循环的加减，脱离本意
			int m = i, n = i; 
			//！！！第一个判断有++n，且必会执行，第二个不能再使用++n，避免判断不一致
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
