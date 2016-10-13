/*
 * ����ĸ���
 * ԭ��
 * 1����ԭʼ�����ÿ���ڵ���Ƶ�ǰ���  A B C D ->> A A B B C C D D
 * 2��������������õ�����ԭʼ����A A B B C C D D -->> A B C D    A B C D
 */
package linkedlist;

public class CopyLinkedList {
	//��Ϊ������ļ򵥸��ƣ�Ҳ���ڲ��ı�ԭ������ṹ����µĸ���
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
	//Ӧ�Ը��������Ƶķ���
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
	//�º�����Ը�������ĸ��ƶ�д��**Ϊ��ӵ�ָ��
	//�����<��ָoffer>.Num 26
	/*
	private static void complexCopy(Node head){
		Node cur = head;
		while(cur != null){
			cur.nextNode.** = cur.**.nextNode; //**Ϊ���ӵ�����ָ��
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
