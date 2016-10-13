/*
 * 求两条链表的第一个公共节点。
 * 此题关键在数据结构，拥有公共节点，
 * 说明两条链表共用第一个公共节点后面的所有节点（每个节点只能有一个nextNode！）
 * 步骤：先求出长度，将长链表先走 error 步
 * 然后将长短链表共同行进，判断其值是否相同！
 */
package linkedlist;

public class FirstCommonNode {
	public static Node getCommon(Node list1,Node list2){
		if(list1 == null || list2 == null) return null;
		int length1 = getListLength(list1);
		int length2 = getListLength(list2);
		Node large = list1;
		Node small = list2;
		int lengthDif = length1 - length2;
		if(length2 > length1){
			large = list2;
			small = list1;
			lengthDif = length2 - length1;
		}
		for(int i = 0;i < lengthDif;i++)
			large = large.nextNode;
		while(large != null && small != null){
			if(large.value == small.value)
				return small;
			large = large.nextNode;
			small = small.nextNode;
		}
		return null;
	}
	private static int getListLength(Node list){
		int length = 0;
		Node cur = list; //不改变原来链表，必须复制引用！！！！
		while(cur != null){
			length ++;
			cur = cur.nextNode;
		}
		return length;
	}
	public static void main(String[] args){
		//公共节点，不是简单的value相同,此为简单测试，内部结构实为两条并行链表，并不满足要求！！！
		int[] a = new int[]{5,8,6,4,3,0,2,7};
		int[] b = new int[]{3,0,2,7};
		Node alist = LinkedList.getList(a);
		Node blist = LinkedList.getList(b);
		System.out.println(getCommon(alist,blist));
	}
}
