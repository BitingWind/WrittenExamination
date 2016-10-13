/*
 * �ɶ�������ǰ��A������B��������Ψһ�Ķ�����
 * 1��ǰ��ĵ�һ��Ԫ��Ϊ���ڵ㣬
 * 2���ɸ��ڵ��ֵ��B�в����±꣬�±����Ϊ���������Ҳ�Ϊ������
 * 3��������������
 * 4������ A B �ݹ��������±꣬�ظ����� 123������ÿ���ڵ�
 * ��������1.��λ�±�   ����   ��λ�±�   �÷�֧Ϊ��
 *         2.��λ�±�   ����   ��λ�±�   �÷�֧ΪҶ�ڵ㣬�½�������
 */
package tree;

import java.util.*;

public class RecoverBinaryTree {
	public static BinaryNode constructBinaryTree(List<Integer> preList,List<Integer> inList){
		int N = preList.size();
		int M = inList.size();
		int[] a = new int[N];
		int[] b = new int[M];
		for(int i = 0;i < N;i++)
			a[i] = preList.get(i);
		for(int j = 0;j < M;j++)
			b[j] = inList.get(j);
		BinaryNode root = recover(a,b);
		return root;
	}
	public static BinaryNode recover(int[] a,int[] b){
		BinaryNode root = recover(a,0,a.length-1,b,0,b.length-1);
		return root;
	}
	private static BinaryNode recover(int[] a,int lo,int hi,
			int[] b,int blo,int bhi){
		if(lo > hi) return null; //!!!!! ��ʱ����/������Ϊ�� ��������
		if(lo == hi)return new BinaryNode(a[lo],null,null);	//!!!��ʱ�ýڵ�Ϊleaf�ڵ�
		int rootInt = a[lo];
		int indexInB = findIndex(b,rootInt);
		int leftLength = indexInB - blo;        //����������
		BinaryNode left =  recover(a,lo + 1,lo + leftLength,b,blo,indexInB-1);
		BinaryNode right = recover(a,lo + leftLength + 1,hi,b,indexInB + 1,bhi);
		return new BinaryNode(a[lo],left,right);
	}
	private static int findIndex(int[] array,int value){
		for(int i=0;i<array.length;i++){
			if(array[i] == value) return i;
		}
		return -1;
	}
	public static void main(String[] args){
		BinaryNode node7 = new BinaryNode(7,null,null);
		BinaryNode node4 = new BinaryNode(4,null,node7);
		BinaryNode node2 = new BinaryNode(2,node4,null);
		
		BinaryNode node5 = new BinaryNode(5,null,null);
		BinaryNode node8 = new BinaryNode(8,null,null);
		BinaryNode node6 = new BinaryNode(6,node8,null);
		BinaryNode node3 = new BinaryNode(3,node5,node6);
		
		BinaryNode node1 = new BinaryNode(1,node2,node3);
		
		Traversal.preorder(node1); // 1 2 4 7 3 5 6 8
		System.out.println();
		Traversal.inorder(node1);  // 4 7 2 1 5 3 8 6
		System.out.println();
		Traversal.postorder(node1);// 7 4 2 5 8 6 3 1
		System.out.println();
		int[] a = new int[]{1,2,4,7,3,5,6,8};
		int[] b = new int[]{4,7,2,1,5,3,8,6};
		
		BinaryNode root = RecoverBinaryTree.recover(a,b);
		Traversal.preorder(root);
	}
}
