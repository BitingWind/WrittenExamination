/* Morris中序遍历<空间O(1)>不需要栈步骤：
 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
 * a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
 * b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
 * 3. 重复以上1、2直到当前节点为空。
 */
package tree;

public class MorrisTraversal {
	public static void traversal(BinaryNode root){
		if(root == null) return;
		BinaryNode pre = null; //用于遍历本身，不做逻辑应用
		BinaryNode cur = root;
		BinaryNode theLast = null;
		BinaryNode firstNode = null;
		BinaryNode nextNode = null;
		while(cur != null){
			if(cur.left == null){
				//逻辑操作位置！！！！
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
				while(pre.right != null && pre.right != cur){ //在左子树中寻找最右侧节点，为本次root的中序前驱节点！！
					pre = pre.right;
				}
				if(pre.right == null){  
					pre.right = cur;   //添加线索，指向中序遍历的下一个节点，即本次的root！！
					cur = cur.left;
				}
				if(pre.right == cur){
					//同上逻辑操作，可作为私有函数，不过参数太多，不方便！！
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
					pre.right = null;   //删除线索，恢复原状！！！
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
