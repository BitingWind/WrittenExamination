package basic;
import java.util.Stack;
public class Stack2Queue<T> {
	public Stack<T> spush, spop;
	public Stack2Queue(){
		spush = new Stack<T>();
		spop = new Stack<T>();
	}
	public void append(T t){
		spush.push(t);
	}
	public T delete(){
		if(spop.size() != 0){
			return spop.pop();
		}
		else if(spush.size() != 0){
			int size = spush.size();//！！！！！size()一直在变，不能放在循环内！切记！！
			for(int i = 0;i< size;i++)
				spop.push(spush.pop());
			return spop.pop();
		}
		else return null;
	}
	public static void main(String[] args){
		Stack2Queue<Integer> s = new Stack2Queue<Integer>();
		s.append(5);s.append(4);s.append(3);s.append(2);
		System.out.println(s.delete());
		System.out.println(s.delete());
		System.out.println(s.delete());
		System.out.println(s.delete());
	}
}
