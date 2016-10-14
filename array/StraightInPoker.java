/*
 * ������5���ƣ��ж��ǲ���˳�ӣ�JQKΪ11 12 13 ���ƿ��Ա�ʾ�����ƣ���������С��
 * ���裺����һ������洢ÿ���Ƶĳ��ִ������������飬����������֮��ġ��������
 * �жϱ�׼�������Ƴ��ֶ�Σ��ز�Ϊ˳��
 *  		�����С�ڵ�����������Ϊ˳�ӣ�������
 */
package array;

public class StraightInPoker {
	public static boolean isStraight(int[] a) throws IllegalArgumentException {
		if(a == null || a.length != 5)
			throw new IllegalArgumentException("You should get FIVE poker!!");
		int[] pokerNum = new int[14];
		for(int i = 0; i < pokerNum.length; i++)
			pokerNum[i] = 0;
		for(int i : a){
			if(i < 0 || i > 13) 
				throw new IllegalArgumentException("The number of pokers should locate in 0~13 !!");
			pokerNum[i]++;
		}
		int numOf0 = pokerNum[0];//���������ʾ
		if(numOf0 > 2) throw new IllegalArgumentException("The trump is only 2 !!");
		int lastPoker = -1;
		int curPoker = -1;
		int sumOfInter = 0;
		for(int i = 1; i < pokerNum.length; i++){
			if(pokerNum[i] == 0) continue;
			if(pokerNum[i] > 1) return false;
			curPoker = i;
			if(lastPoker == -1) lastPoker = curPoker;//��ǰֵ
			else{
				sumOfInter += (curPoker - lastPoker - 1); //�����������1 ����������
				lastPoker = curPoker;
			}
		}
		if(sumOfInter <= numOf0) return true; //������С�ڵ������Ƶ�����������Ϊ˳�ӣ�
		else return false;
	}
	public static void main(String[] args){
		int[] pokers = new int[]{0,2,3,6,0};
		System.out.println(isStraight(pokers));
	}
}
