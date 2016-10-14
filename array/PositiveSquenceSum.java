/*
 * �������к�Ϊ�̶�ֵ��������������
 */
package array;

public class PositiveSquenceSum {
	public static void sequenceQuick(int value){
		int lo = 1;
		int hi = 2;
		int curSum = lo + hi;
		while(lo < value/2 + 1){
			if(curSum == value) print(lo,hi);
			else if(curSum > value){ //��״̬ת�䣬�ɴ���--��С��
				while(curSum > value && lo < value/2 + 1){
					curSum -= lo;
					lo++;
					if(curSum == value) print(lo,hi);
				}
			}
			hi++; //  < or == 
			curSum += hi;
		}
	}
	//����������ͺ����������ظ��ȸߣ���
	public static void sequence(int value){
		int lo = 1;
		int hi = 2;   //����ָ�룬ͨ�����������ı�͵�ֵ
		while(lo < value/2 + 1){  //�߽�����lo + lo+1 = value
			int sum = sumOfseq(lo,hi);
			if(sum < value) hi++;
			else if(sum > value) lo++;
			else {
				print(lo,hi);
				hi++;
			}
		}
	}
	private static int sumOfseq(int lo,int hi){
		int result = 0;
		for(int i = lo;i <= hi;i++)
			result += i;
		return result;
	}
	private static void print(int lo,int hi){
		for(int i = lo;i <= hi;i++)
		    System.out.format("%d ",i);
		System.out.println();
	}
	public static void main(String[] args){
		sequenceQuick(15);
	}
}
