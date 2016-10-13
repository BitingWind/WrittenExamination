package tree;

public class MaxDepth {
	public static int depth(BinaryNode root){
		if(root == null)return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if(left > right) return left + 1; //��1�ܹؼ�������
		else return right + 1;
	}
	public static int minDepth(BinaryNode root){
		if(root == null) return 0;
		return minDepth(root,false);
	}
	//˼�����Ҫ���ж��Ƿ�ΪҶ�ڵ㣬�����ֵܽڵ㣬��Ϊ���ֵ�������ڱȽϷ��أ���
	private static int minDepth(BinaryNode root,boolean hasBrother){
		if(root == null) return hasBrother ? Integer.MAX_VALUE : 0;
		int left = minDepth(root.left,root.right != null);
		int right = minDepth(root.right,root.left != null);
		return  left < right ? (left + 1) : (right + 1);
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinaryTree();
		Traversal.preorder(root);
		System.out.println();
		System.out.println(minDepth(root));
	}
}
