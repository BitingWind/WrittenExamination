package tree;
import java.util.*;
public class TraversalOnStack {
	public static void pre(BinaryNode p){
		if(p == null) return;
		System.out.println(p.value);//handle
		pre(p.left);
		pre(p.right);
	} 
	public static void in(BinaryNode p){
		if(p == null) return;
		in(p.left);
		System.out.println(p.value);//handle
		in(p.right);
	}
	public static void post(BinaryNode p){
		if(p == null) return;
		post(p.left);
		post(p.right);
		System.out.println(p.value);//handle
	}
	public static void preorder(BinaryNode p){
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		while(p != null || !s.isEmpty()){
			while(p != null){
				System.out.println(p.value);//handle
				s.push(p);
				p = p.left;
			}
			if(!s.isEmpty()){
				p = s.pop();
				p = p.right;
			}
		}
	}
	public static void inorder(BinaryNode p){
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		while(p != null || !s.isEmpty()){
			while(p != null){
				s.push(p);
				p = p.left;
			}
			if(!s.isEmpty()){
				p = s.pop();
				System.out.println(p.value);//handle 
				p = p.right;
			}
		}
	}
	public static void postorder(BinaryNode p){
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		BinaryNode cur;
		BinaryNode pre = null;
		s.push(p);
		while(!s.isEmpty()){
			cur = s.peek();
			if((cur.left == null && cur.right == null)||
					(pre !=null &&(pre == cur.left || pre == cur.right))){
				System.out.println(cur.value);
				s.pop();
				pre = cur;//important!!
			}
			else {
				if(cur.right != null)// right is always befor left,important!!
					s.push(cur.right);
				if(cur.left != null)
					s.push(cur.left);
			}
		}
	}
	public static void morrisInorder(BinaryNode p){
		BinaryNode pre,cur;
		while(p != null){
			cur = p;
			if(p.left == null){
				System.out.println(p.value);//handle
				p = p.right;
			}
			else{
				pre = p.left;
				while(pre.right != null && pre.right != cur)
					pre = pre.right;
				if(pre.right == null){
					pre.right = cur;
				//	System.out.println(p.value);  //the morrisPreOrder handle code , replace the code in row 72
					p = p.left;
				}	
				else{
					pre.right = null; //recover the tree ,important!!
					System.out.println(p.value);//handle
					p = p.right;
				}
			}
		}
	}
	public static void main(String[] args){
		BinaryNode n4 = new BinaryNode(4,null,null);
		BinaryNode n2 = new BinaryNode(2,null,n4);
		BinaryNode n5 = new BinaryNode(5,null,null);
		BinaryNode n3 = new BinaryNode(3,n5,null);
		BinaryNode n1 = new BinaryNode(1,n2,n3);
		post(n1);
	}
}
