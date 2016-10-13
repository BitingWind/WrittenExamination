package linkedlist;

public class RemoveSpecificNode {
	public static Node remove(Node root,Node spec){
		if(root == null) return null;
		if(spec.nextNode == null){
			Node cur = root;
			if(cur.value == spec.value) return null; //链表中仅有一个节点，且要求删除
			while(cur.nextNode.value != spec.value){
				cur = cur.nextNode;
			}
			cur.nextNode = null; //cur为复制的引用，此操作为唯一改变原链表结构之操作（删除）！！！！
			return root;
		}
		else{
			Node specNext = spec.nextNode;
			spec.value = specNext.value;
			spec.nextNode = specNext.nextNode;
			//specNext.nextNode = null; //不指定删除亦可
			return root;
		}
	}
	public static void main(String[] args){
		Node n0 = new Node(0,null);
		Node n1 = new Node(1,n0);
		Node n2 = new Node(2,n1);
		Node n3 = new Node(3,n2);
		Node n4 = new Node(4,n3);
		Node n5 = new Node(5,n4);
		Node n6 = new Node(6,n5);
		System.out.println(n6);
		System.out.println(remove(n0,n0));	
	}
}
