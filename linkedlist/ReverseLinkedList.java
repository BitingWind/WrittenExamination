/*
 * 反转链表，遍历一遍的同时使链表反转，in-place,in one-pass
 */
package linkedlist;


class Reverse{
	public static Node reserve(Node first){
		if(first == null) return first;
		Node pre = first;
		Node cur = first.nextNode;
		Node next;//缓冲引用
		while(cur != null){
			next = cur.nextNode;//截断
			cur.nextNode = pre;//反向
			pre = cur;  //更新
			cur = next;
		}
		first.nextNode = null;//原来的头指针，现在的尾指针，next赋null
		first = pre;          //现在的头指针
		return first;
	}
}
public class ReverseLinkedList{
	public ReverseLinkedList(){}
	public ReverseLinkedList(Node first){
		this.first = first;
	}
	public Node first;
	public void push(int value){
		Node x = new Node(value);
		if(first == null) first = x;
		else {
			x.nextNode = first;
			first = x;
		}
	}
	public Node getList(){
		return first;
	}
	public String toString(){
		Node x = first;
		StringBuilder sb = new StringBuilder("list: ");
		while(x.nextNode != null){
			sb.append(x.value);
			sb.append("->");
			x = x.nextNode;
		}
		sb.append(x.value);
		return sb.toString();
	}
	public static void main(String[] args){
		ReverseLinkedList rll = new ReverseLinkedList();
		for(int i=0;i<10;i++)rll.push(i);
		Node re = Reverse.reserve(rll.first);
		System.out.println(new ReverseLinkedList(re));
	}
}
