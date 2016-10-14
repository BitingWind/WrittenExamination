package huaweiOJ;
import java.util.*;
public class ReconstructSequence {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			int k = scan.nextInt();
			int[] seqNull = new int[n];
			//����������Ϊ�±꣬�衾n+1����
			boolean[] isView = new boolean[n+1];
			//ArrayList<Integer> location = new ArrayList<Integer>();
			for(int i = 0; i < n; i++){
				int num = scan.nextInt();
				seqNull[i] = num;
				//�Ѿ�������������λ���棡��
				isView[num] = true;
			}
			ArrayList<Integer> nullList = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++){
				if(!isView[i]) nullList.add(i);
			}
			ArrayList<ArrayList<Integer>> seqList = getSequenceList(nullList);
			int result = 0;
			for(ArrayList<Integer> l : seqList){
				if(isK(seqNull,l,k)){
					result++;
				}
			}
			System.out.println(result);
		}
	}
	private static boolean isK(int[] a,ArrayList<Integer> list,int k){
		int nextIndex = 0;
		int count = 0;
		//ע�⣡�����ɶ�ԭ�����޸ģ�����
		int[] b = new int[a.length];
		//������ǰ�����µ���������
		for(int i = 0; i < a.length; i++){
			if(a[i] == 0)b[i] = list.get(nextIndex++);
			else b[i] = a[i];
		}
		//��������˳��Եĸ���
		for(int i = 0; i < b.length; i++){
			for(int j = i + 1; j < b.length; j++){
				if(b[i] < b[j]){
					count++;
					if(count > k) return false;
				}
			}
		}
		if(count == k) return true;
		else return false;
	}
	//�������ֻ��ַ�������ȫ����,��̬�滮���¼���Ԫ�غ�����У�Ϊǰһ�����е����е���ǰ�����+1��λ�ò��������Ԫ��
	private static ArrayList<ArrayList<Integer>> getSequenceList(ArrayList<Integer> list){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//��ʼ״̬��������һ����Ԫ�ص�List�����У�������������
		result.add(new ArrayList<Integer>());
		
		for(int i: list){
			//result��Ŀǰ�汾 ��ÿ�ξ�Ϊ�գ�����add����������for������
			ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
			//������ǰresult�����е�list
			for(ArrayList<Integer> al : result){
				//�����е���ǰ����������λ�ò�����һ�ֵ�Ԫ��
				for(int j = 0; j <= al.size(); j++){
					al.add(j,i);
					//ע�⣬���븱��
					cur.add(new ArrayList<Integer>(al));
					//ԭ���汾�ع�ԭ̬��������һ��λ�õĲ���
					al.remove(j);
				}
			}
			//��Ŀǰ�汾���������հ汾������������һ��ѭ��
			result = new ArrayList<ArrayList<Integer>>(cur);
		}
		return result;
	}
}
