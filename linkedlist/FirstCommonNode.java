/*
 * ����������ĵ�һ�������ڵ㡣
 * ����ؼ������ݽṹ��ӵ�й����ڵ㣬
 * ˵�����������õ�һ�������ڵ��������нڵ㣨ÿ���ڵ�ֻ����һ��nextNode����
 * ���裺��������ȣ������������� error ��
 * Ȼ�󽫳�������ͬ�н����ж���ֵ�Ƿ���ͬ��
 */
package linkedlist;

public class FirstCommonNode {
	public static Node getCommon(Node list1,Node list2){
		if(list1 == null || list2 == null) return null;
		int length1 = getListLength(list1);
		int length2 = getListLength(list2);
		Node large = list1;
		Node small = list2;
		int lengthDif = length1 - length2;
		if(length2 > length1){
			large = list2;
			small = list1;
			lengthDif = length2 - length1;
		}
		for(int i = 0;i < lengthDif;i++)
			large = large.nextNode;
		while(large != null && small != null){
			if(large.value == small.value)
				return small;
			large = large.nextNode;
			small = small.nextNode;
		}
		return null;
	}
	private static int getListLength(Node list){
		int length = 0;
		Node cur = list; //���ı�ԭ���������븴�����ã�������
		while(cur != null){
			length ++;
			cur = cur.nextNode;
		}
		return length;
	}
	public static void main(String[] args){
		//�����ڵ㣬���Ǽ򵥵�value��ͬ,��Ϊ�򵥲��ԣ��ڲ��ṹʵΪ��������������������Ҫ�󣡣���
		int[] a = new int[]{5,8,6,4,3,0,2,7};
		int[] b = new int[]{3,0,2,7};
		Node alist = LinkedList.getList(a);
		Node blist = LinkedList.getList(b);
		System.out.println(getCommon(alist,blist));
	}
}
