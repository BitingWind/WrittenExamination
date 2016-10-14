package huaweiOJ;
import java.util.*;
public class ReconstructSequence {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int k = scan.nextInt();
			int[] seqNull = new int[n];
			//由数本身作为下标，需【n+1】！
			boolean[] isView = new boolean[n+1];
			//ArrayList<Integer> location = new ArrayList<Integer>();
			for(int i = 0; i < n; i++){
				int num = scan.nextInt();
				seqNull[i] = num;
				//已经读到的数，该位置真！！
				isView[num] = true;
			}
			ArrayList<Integer> nullList = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++){
				if(!isView[i]) nullList.add(i);
			}
			ArrayList<ArrayList<Integer>> seqList = getSequenceList(nullList);
			int result = 0;
			for(ArrayList<Integer> l : seqList){
				if(isK(seqNull,l,k)){
					result++;
				}
			}
			System.out.println(result);
		}
	}
	private static boolean isK(int[] a,ArrayList<Integer> list,int k){
		int nextIndex = 0;
		int count = 0;
		//注意！！不可对原数组修改！！！
		int[] b = new int[a.length];
		//构建当前排列下的完整数组
		for(int i = 0; i < a.length; i++){
			if(a[i] == 0)b[i] = list.get(nextIndex++);
			else b[i] = a[i];
		}
		//暴力计算顺序对的个数
		for(int i = 0; i < b.length; i++){
			for(int j = i + 1; j < b.length; j++){
				if(b[i] < b[j]){
					count++;
					if(count > k) return false;
				}
			}
		}
		if(count == k) return true;
		else return false;
	}
	//给定数字或字符串，求全排列,动态规划，新加入元素后的排列，为前一个已有的排列的最前到最后+1的位置插入这个新元素
	private static ArrayList<ArrayList<Integer>> getSequenceList(ArrayList<Integer> list){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//初始状态，必须有一个零元素的List在其中！！！！！！！
		result.add(new ArrayList<Integer>());
		
		for(int i: list){
			//result的目前版本 ，每次均为空，重新add，作用域在for（）里
			ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
			//遍历当前result中已有的list
			for(ArrayList<Integer> al : result){
				//在已有的最前到最后的所有位置插入新一轮的元素
				for(int j = 0; j <= al.size(); j++){
					al.add(j,i);
					//注意，插入副本
					cur.add(new ArrayList<Integer>(al));
					//原来版本回归原态，进行下一个位置的插入
					al.remove(j);
				}
			}
			//将目前版本更新至最终版本，输出或进行下一次循环
			result = new ArrayList<ArrayList<Integer>>(cur);
		}
		return result;
	}
}
