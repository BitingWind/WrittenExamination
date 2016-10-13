/*
 * 求二叉树的镜像树
 * 步骤：在中序遍历的基础上，进行左右交换
 * 返回条件：叶节点
 */
package tree;

public class MirrorTree {
	public static void mirror(BinaryNode root){
		if(root == null) return;
		if(root.left == null && root.right == null)
			return;
		BinaryNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinaryTree();
		Traversal.preorder(root);
		System.out.println();
	//	mirror(root);
		Traversal.postorder(root);
	}
}
