package linkedlist;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> s;
	private Stack<Integer> sAux;
	private int min;
	public MinStack(){
		s = new Stack<Integer>();
		sAux = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}
	public void push(int x){
		s.push(x);
		if(x < min) min = x;
		sAux.push(min);
	}
	public int pop()throws IllegalStateException{
		if(s.isEmpty()) 
			throw new IllegalStateException("The Stack is Null");
		sAux.pop();
		return s.pop();	
	}
	public int min()throws IllegalStateException{
		if(sAux.isEmpty())
			throw new IllegalStateException("The Stack is Null");
		return sAux.peek();
	}
	public static void main(String[] args){
		MinStack ms = new MinStack();
		ms.push(3);
		ms.push(4);
		System.out.println(ms.min());
		ms.push(2);
		ms.push(5);
		System.out.println(ms.min());
		ms.pop();
		ms.pop();ms.pop();ms.pop();
		System.out.println(ms.min());
	}
}
