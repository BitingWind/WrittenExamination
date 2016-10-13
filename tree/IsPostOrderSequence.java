/*
 * �ж�һ�������Ƿ�Ϊĳ�����������ĺ������
 * ����������������ģ����ص㣺
 * ��ĩβ��Ԫ��Ϊroot
 * ��ǰ�棬һ����Ԫ��ȫ��С��root
 * ���һ���ֱ���ȫ�����ڣ�����������
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
		return isPost(post,lo,part-1) && isPost(post,part,hi-1);//ע��˾���ʽ�����ڵݹ��жϺܳ��ã���
	}
	public static void main(String[] args){
		BinaryNode root = BinaryTree.getBinarySearchTree();
		Traversal.postorder(root);
		int[] post = new int[]{3,1,2,5,7,6,8,4};
		System.out.println(isPost(post));
	}
}
