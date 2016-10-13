package linkedlist;

public class Node{
	int value;
	Node nextNode;
	public Node(int value){
		this.value = value;
	}
	public Node(int value,Node nextNode){
		this.value = value;
		this.nextNode = nextNode;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("list:");
		sb.append(value);
		Node cur = nextNode; //toString��һ��ֻ������������ֱ�Ӳ����������븴�ƣ���
		while(cur != null){
			sb.append("->");
			sb.append(cur.value);
			cur = cur.nextNode;
		}
		return sb.toString();
	}
}