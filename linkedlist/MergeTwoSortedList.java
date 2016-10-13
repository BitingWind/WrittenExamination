package linkedlist;

public class MergeTwoSortedList {
	public static Node merge(Node listOne,Node listTwo){
		if(listOne == null)
			return listTwo;
		if(listTwo == null)
			return listOne;
		Node first;
		if(listOne.value <= listTwo.value){
			first = listOne;
			listOne = listOne.nextNode;
		}
		else {
			first = listTwo;
			listTwo = listTwo.nextNode;
		}
		Node cur = first;
		while(listOne != null || listTwo != null){
			if(listTwo == null){
				cur.nextNode = listOne;
				listOne = listOne.nextNode;
			}
			else if(listOne == null){
				cur.nextNode = listTwo;
				listTwo = listTwo.nextNode;
			}
			else if(listOne.value <= listTwo.value){
				cur.nextNode = listOne;
				listOne = listOne.nextNode;
			}
			else {
				cur.nextNode = listTwo;
				listTwo = listTwo.nextNode;	
			}
			cur = cur.nextNode;
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
		System.out.println(merge(n2,n6));
	}
}
