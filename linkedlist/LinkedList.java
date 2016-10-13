package linkedlist;

public class LinkedList {
	public static Node getList(int[] value){
		if(value == null || value.length == 0)return null;
		Node first = new Node(value[0]);
		Node cur = first;
		for(int i = 1;i < value.length;i++){
			Node x = new Node(value[i]);
			cur.nextNode = x;
			cur = x;
		}
		return first;
	}
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5};
		Node x = getList(a);
		System.out.println(x);
	}
}
