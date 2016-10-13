package linkedlist;

public class KthReverse {
	public static Node kthReverse(Node first,int k) throws Exception{
		if(first == null) throw new NullPointerException("The list is null!");
		if(k <= 0) throw new IllegalArgumentException("the k is less than or equeal to 0!");
		Node pre = first;
		Node after = first;
		for(int i = 1;i < k;i++){ //сисз
			if(pre.nextNode == null)
				throw new IllegalArgumentException("The length of the specific List is less than :" + k);
			pre = pre.nextNode;
		}
		while(pre.nextNode != null){
			pre = pre.nextNode;
			after = after.nextNode;
		}
		return after;
	}
	public static void main(String[] args){
		Node n0 = new Node(0,null);
		Node n1 = new Node(1,n0);
		Node n2 = new Node(2,n1);
		Node n3 = new Node(3,n2);
		Node n4 = new Node(4,n3);
		Node n5 = new Node(5,n4);
		Node n6 = new Node(6,n5);
		try{
			Node kth = kthReverse(n6,8);
			System.out.println(kth.value);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
