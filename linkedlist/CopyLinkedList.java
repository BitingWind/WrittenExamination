/*
 * 链表的复制
 * 原理：
 * 1，在原始链表的每个节点后复制当前结点  A B C D ->> A A B B C C D D
 * 2，拆分现有链表，得到两个原始链表：A A B B C C D D -->> A B C D    A B C D
 */
package linkedlist;

public class CopyLinkedList {
	//此为单链表的简单复制，也是在不改变原有链表结构情况下的复制
	public static Node immutableClone( final Node head){
		if(head == null) return null;
		Node newHead = new Node(head.value);
		Node other = newHead;
		Node cur = head.nextNode;
		while(cur != null){
			Node x = new Node(cur.value);
			other.nextNode = x;
			other = x;
			cur = cur.nextNode;
		}
		return newHead;
	}
	//应对复杂链表复制的方法
	public static Node clone(Node head){
		copyNode(head);
		Node headClone = head.nextNode;
		Node cur = head;
		Node other = headClone;
		while(cur != null){
			cur.nextNode = cur.nextNode.nextNode;
			cur = cur.nextNode;
			if(other.nextNode != null){
				other.nextNode = other.nextNode.nextNode;
				other = other.nextNode;
			}	
		}
		return headClone;
	} 
	private static void copyNode(Node head){
		Node cur = head;
		while(cur != null){
			Node x = new Node(cur.value);
			x.nextNode = cur.nextNode;
			cur.nextNode = x;
			cur = x.nextNode;
		}
		return;
	}
	//下函数针对复杂链表的复制而写，**为添加的指针
	//具体见<剑指offer>.Num 26
	/*
	private static void complexCopy(Node head){
		Node cur = head;
		while(cur != null){
			cur.nextNode.** = cur.**.nextNode; //**为复杂的其他指针
			cur = cur.nextNode.nextNode;
		}
		return;
	}
	*/
	public static void main(String[] args){
		ReverseLinkedList rev = new ReverseLinkedList();
		for(int i=0;i<9;i++){
			rev.push(i);
		}
		Node ll = rev.getList();
		//ll =null;
		Node x = immutableClone(ll);
		System.out.println(x);
	}
}
