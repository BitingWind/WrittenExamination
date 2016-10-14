/*
 * 结果不对，待日后在来。。。
 */
package tree;

public class IsBinaryTree {
	private static boolean isBalance(BinaryNode root,int[] deepth){
		if(root == null) {
			deepth[0] = 0; 
			return true;
		}
		int[] leftD = new int[]{0};
		int[] rightD = new int[]{0};
		if(isBalance(root.left,leftD) && isBalance(root.right,rightD)){
			int diff = leftD[0] - rightD[0];
			if(diff <= 1 || diff >= -1){
				deepth[0] = 1 + (leftD[0] < rightD[0]? rightD[0] : leftD[0]);
				leftD = null;
				rightD = null;
				return true;
			}
		}
		return false;
	}
	public static boolean isBalance(BinaryNode root){
		int[] deepth = new int[]{0};
		return isBalance(root,deepth);
	}
	public static void main(String[] args){
		BinaryNode n1 = new BinaryNode(1,null,null);
		BinaryNode n2 = new BinaryNode(2,n1,null);
		BinaryNode n3 = new BinaryNode(3,n2,null);
		System.out.println(isBalance(n3));
	}
}
