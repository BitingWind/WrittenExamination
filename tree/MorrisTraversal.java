/* Morris�������<�ռ�O(1)>����Ҫջ���裺
 * 1. �����ǰ�ڵ������Ϊ�գ��������ǰ�ڵ㲢�����Һ�����Ϊ��ǰ�ڵ㡣
 * 2. �����ǰ�ڵ�����Ӳ�Ϊ�գ��ڵ�ǰ�ڵ�����������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣
 * a) ���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�
 * b) ���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�������Һ���������Ϊ�գ��ָ�������״���������ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ���Һ��ӡ�
 * 3. �ظ�����1��2ֱ����ǰ�ڵ�Ϊ�ա�
 */
package tree;

public class MorrisTraversal {
	public static void traversal(BinaryNode root){
		if(root == null) return;
		BinaryNode pre = null; //���ڱ������������߼�Ӧ��
		BinaryNode cur = root;
		BinaryNode theLast = null;
		BinaryNode firstNode = null;
		BinaryNode nextNode = null;
		while(cur != null){
			if(cur.left == null){
				//�߼�����λ�ã�������
				System.out.print(cur.value+" ");
				if(theLast != null){
					if(theLast.value > cur.value){
						if(firstNode == null) firstNode = theLast;
						nextNode = cur;	
					}	
				}
				theLast = cur;
				//
				cur = cur.right;
			}
			else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){ //����������Ѱ�����Ҳ�ڵ㣬Ϊ����root������ǰ���ڵ㣡��
					pre = pre.right;
				}
				if(pre.right == null){  
					pre.right = cur;   //���������ָ�������������һ���ڵ㣬�����ε�root����
					cur = cur.left;
				}
				if(pre.right == cur){
					//ͬ���߼�����������Ϊ˽�к�������������̫�࣬�����㣡��
					System.out.print(cur.value+" ");
					if(theLast != null){
						if(theLast.value > cur.value){
							if(firstNode == null) firstNode = theLast;
							nextNode = cur;	
						}	
					}
					theLast = cur;
					//
					cur = cur.right;
					pre.right = null;   //ɾ���������ָ�ԭ״������
				}
			}
		}
		if(firstNode != null && nextNode != null){
			int tmp = firstNode.value;
			firstNode.value = nextNode.value;
			nextNode.value = tmp;
		}
	}
	public static void main(String[] args){
		BinaryNode node2 = new BinaryNode(7,null,null);
		BinaryNode node1 = new BinaryNode(1,null,node2);
		BinaryNode node3 = new BinaryNode(3,node1,null);
		
		BinaryNode node5 = new BinaryNode(5,null,null);
		BinaryNode node7 = new BinaryNode(2,null,null);
		BinaryNode node8 = new BinaryNode(8,node7,null);
		BinaryNode node6 = new BinaryNode(6,node5,node8);
		
		BinaryNode node4 = new BinaryNode(4,node3,node6);
		
	/*	Traversal.preorder(node1); // 1 2 4 7 3 5 6 8
		System.out.println();
		Traversal.inorder(node1);  // 4 7 2 1 5 3 8 6
		System.out.println();
		Traversal.postorder(node1);// 7 4 2 5 8 6 3 1
		System.out.println();
		int[] a = new int[]{1,2,4,7,3,5,6,8};
		int[] b = new int[]{4,7,2,1,5,3,8,6};
		
		BinaryNode root = RecoverBinaryTree.recover(a,b);
		*/
		MorrisTraversal.traversal(node4);
		System.out.println();
		MorrisTraversal.traversal(node4);
	}
}
