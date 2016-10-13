/*
 * 和为固定值得路径，由根到叶节点，为一个路径
 */
package tree;

import java.util.*;

public class SumPath {
	public static void printPath(BinaryNode root ,int value){
		ArrayList<Integer> path = new ArrayList<Integer>();
		int curValue = 0;
		printPath(root,path,curValue,value);
	}
	private static void printPath(BinaryNode node,ArrayList<Integer> path,int curValue,int value){
		if(node == null) return;
		path.add(node.value);
		curValue = curValue + node.value;
		if(node.left == null && node.right == null && curValue == value){
			StringBuilder s = new StringBuilder("A path is found: ");
			for(int i : path){
				s.append(i);
				s.append("->");
			}
			s.delete(s.length() - 2,s.length());//[*,*) 左含，右不含
			System.out.println(s);
		}
		printPath(node.left,path,curValue,value);
		printPath(node.right,path,curValue,value);
		
		path.remove(path.size()-1);//上爬操作，删除末尾元素
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinaryTree();
		printPath(root,14);
	}
	
}
