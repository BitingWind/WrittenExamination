package linkedlist;

public class MergeTwoList2 {
	public static Node merge(Node list1,Node list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		Node first = null;
		if(list1.value <= list2.value){
			first = list1;
			list1.nextNode = merge(list1.nextNode,list2);
		}
		else{
			first = list2;
			list2.nextNode = merge(list1,list2.nextNode);
		}
		return first;
	}
	public static void main(String[] args){
		Node n0 = new Node(6,null);
		Node n1 = new Node(3,n0);
		Node n2 = new Node(1,n1);
		Node n3 = new Node(7,null);
		Node n4 = new Node(5,n3);
		Node n5 = new Node(4,n4);
		Node n6 = new Node(2,n5);
		System.out.println(n2);
		System.out.println(n6);
		System.out.println(merge(n1,n4));
	}
}
