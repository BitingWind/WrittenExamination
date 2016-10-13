package tree;

public class IsSunTree {
	public static boolean isSub(BinaryNode t1,BinaryNode t2){
		boolean result = false;
		if(t1 != null && t2 != null){
			if(t1.value == t2.value)
				result = isHave(t1,t2);
			if(!result)
				result = isSub(t1.left,t2);
			if(!result)
				result = isSub(t1.right,t2);
		}
		return result;
	}
	private static boolean isHave(BinaryNode t1,BinaryNode t2){
		if(t2 == null) return true;
		if(t1 == null) return false;
		if(t1.value != t2.value) return false;
		return isHave(t1.left,t2.left) && isHave(t1.right,t2.right);
 	}
	public static void main(String[] args){
		BinaryNode node7 = new BinaryNode(7,null,null);
		BinaryNode node4 = new BinaryNode(4,null,node7);
		BinaryNode node2 = new BinaryNode(2,node4,null);
		
		BinaryNode node5 = new BinaryNode(5,null,null);
		BinaryNode node8 = new BinaryNode(8,null,null);
		BinaryNode node6 = new BinaryNode(6,node8,null);
		BinaryNode node3 = new BinaryNode(3,node5,node6);
		
		BinaryNode node1 = new BinaryNode(1,node2,node3);
		
		BinaryNode nodeSub2 = new BinaryNode(6,null,null);
		BinaryNode nodeSub3 = new BinaryNode(3,null,null);
		BinaryNode nodeSub1 = new BinaryNode(1,nodeSub2,nodeSub3);
		System.out.println(isSub(node1,nodeSub1));
	}
}
