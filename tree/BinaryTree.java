package tree;

import java.util.*;

public class BinaryTree {
	public static BinaryNode getBinaryTree(){
		BinaryNode node7 = new BinaryNode(7,null,null);
		BinaryNode node4 = new BinaryNode(4,null,node7);
		BinaryNode node2 = new BinaryNode(2,node4,null);
		
		BinaryNode node5 = new BinaryNode(5,null,null);
		BinaryNode node8 = new BinaryNode(8,null,null);
		BinaryNode node6 = new BinaryNode(6,node8,null);
		BinaryNode node3 = new BinaryNode(3,node5,node6);
		
		BinaryNode node1 = new BinaryNode(1,node2,node3);
		
		return node1;
	}
	public static BinaryNode getBinarySearchTree(){
		BinaryNode node2 = new BinaryNode(2,null,null);
		BinaryNode node1 = new BinaryNode(1,null,node2);
		BinaryNode node3 = new BinaryNode(3,node1,null);
		
		BinaryNode node5 = new BinaryNode(5,null,null);
		BinaryNode node7 = new BinaryNode(7,null,null);
		BinaryNode node8 = new BinaryNode(8,node7,null);
		BinaryNode node6 = new BinaryNode(6,node5,node8);
		
		BinaryNode node4 = new BinaryNode(4,node3,node6);
		return node4;
	}
	public static BinaryNode clone(BinaryNode root){
		ArrayList<Integer> preList = new ArrayList<Integer>();
		ArrayList<Integer> inList = new ArrayList<Integer>();
		Traversal.getPreList(root, preList);
		Traversal.getInList(root, inList);
		return RecoverBinaryTree.constructBinaryTree(preList, inList);	
	}
	public static BinaryNode getBTFromPreIn(List<Integer> preList,List<Integer> inList){
		return RecoverBinaryTree.constructBinaryTree(preList, inList);
	}
	public static void main(String[] args){
		List<Integer> pre = new ArrayList<Integer>(Arrays.asList(1,2,4,7,3,5,6,8));
		List<Integer> in = new ArrayList<Integer>(Arrays.asList(4,7,2,1,5,3,8,6));
		BinaryNode tree = getBTFromPreIn(pre,in);
		Traversal.preorder(tree);
		System.out.println();
		BinaryNode tree1 = clone(tree);
		Traversal.postorder(tree1);
	}
}
