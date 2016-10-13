package tree;

import java.util.*;

public class Traversal{
	public static void preorder(BinaryNode root){
		if(root == null) return;
		System.out.print(root.value + " ");
		preorder(root.left);
		preorder(root.right);
	}
	public static  void getPreList(BinaryNode root,ArrayList<Integer> list){
		if(root == null) return; 
		list.add(root.value);
		getPreList(root.left,list);
		getPreList(root.right,list);
	}
	public static void inorder(BinaryNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	public static  void getInList(BinaryNode root,ArrayList<Integer> list){
		if(root == null) return; 
		list.add(root.value);
		getInList(root.left,list);
		getInList(root.right,list);
	}
	public static void postorder(BinaryNode root){
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value + " ");
	}
	public static  void getPostList(BinaryNode root,ArrayList<Integer> list){
		if(root == null) return; 
		list.add(root.value);
		getPostList(root.left,list);
		getPostList(root.right,list);
	}
	public static void levorder(BinaryNode root){
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode node = queue.poll();
			
			System.out.print(node.value + " "); //²Ù×÷Î»ÖÃ
			
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
	}
	public static void getLevelList(BinaryNode root,ArrayList<ArrayList<Integer>> result){
		int level = 0;
		ArrayList<ArrayList<BinaryNode>> nodes = new ArrayList<ArrayList<BinaryNode>>();
		nodes.add(new ArrayList<BinaryNode>(Arrays.asList(root)));
		result.add(new ArrayList<Integer>(Arrays.asList(root.value)));
		while(!nodes.get(level++).isEmpty()){
			ArrayList<BinaryNode> preLevel = nodes.get(level -1);
			ArrayList<BinaryNode> levList = new ArrayList<BinaryNode>();
			ArrayList<Integer> levResult = new ArrayList<Integer>();
			for(int i = 0;i < preLevel.size();i++){
				BinaryNode nodeI = preLevel.get(i);
				if(nodeI.left != null){
					levList.add(nodeI.left);
					levResult.add(nodeI.left.value);
				}
				if(nodeI.right != null){
					levList.add(nodeI.right);
					levResult.add(nodeI.right.value);
				}
			}
			nodes.add(levList);
			result.add(levResult);
		}
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinaryTree();
		Traversal.levorder(root);
		System.out.println();
		//mirror(root);
		ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
		getLevelList(root,levelList);
		System.out.println(levelList);
		
	}
}
