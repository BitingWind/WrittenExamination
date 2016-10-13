/*
 * ��ת��������һ���ͬʱʹ����ת��in-place,in one-pass
 */
package linkedlist;


class Reverse{
	public static Node reserve(Node first){
		if(first == null) return first;
		Node pre = first;
		Node cur = first.nextNode;
		Node next;//��������
		while(cur != null){
			next = cur.nextNode;//�ض�
			cur.nextNode = pre;//����
			pre = cur;  //����
			cur = next;
		}
		first.nextNode = null;//ԭ����ͷָ�룬���ڵ�βָ�룬next��null
		first = pre;          //���ڵ�ͷָ��
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
