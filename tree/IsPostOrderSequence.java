/*
 * 判断一个序列是否为某二叉搜索树的后序遍历
 * 二叉搜索树是有序的，有特点：
 * 在末尾的元素为root
 * 在前面，一部分元素全部小于root
 * 其后一部分必须全部大于，才满足条件
 */
package tree;

public class IsPostOrderSequence {
	public static boolean isPost(int[] post){
		if(post == null) return false;
		int N = post.length;
		return isPost(post,0,N-1);
	}
	private static boolean isPost(int[] post,int lo, int hi){
		if(lo >= hi) return true;
		int rootV = post[hi];
		int part;
		for(part = lo;part < hi;part++){
			if(post[part] > rootV)
				break;
		}
		for(int i = part;i < hi;i++)
			if(post[i] < rootV)
				return false;
		return isPost(post,lo,part-1) && isPost(post,part,hi-1);//注意此句形式，对于递归判断很常用！！
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinarySearchTree();
		Traversal.postorder(root);
		int[] post = new int[]{3,1,2,5,7,6,8,4};
		System.out.println(isPost(post));
	}
}
