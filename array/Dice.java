package array;

public class Dice {
	static final int DICE_NUM = 6; 
	public static void printFrequency(int num){
		if(num <= 0) 
			System.out.println("The num of dices should > 0 !");
		int[][] pro = new int[][]{new int[num * DICE_NUM + 1],new int[num * DICE_NUM + 1]};
		for(int i = 0; i <= num * DICE_NUM; i++){
			pro[0][i] = 0;
			pro[1][i] = 0;
		}
		int flag = 0;
		for(int i = 1; i <= DICE_NUM;i++) //���ã�ɫ������Ϊ1ʱ�ĸ��������ִ�����0����
			pro[flag][i] = 1;
		for(int k = 2;k <= num;k++){
			for(int i = 1;i < k;i++){     //ɫ����Ϊkʱ��k���²�����֣�������
				pro[1 - flag][i] = 0;
			}
			for(int i = k;i <= k * DICE_NUM;i++){
				pro[1 - flag][i] = 0;     //��Ҫ���µĵ������ִ�����Ϊ�㣬���¼���
				for(int j = 1;j <= i && j <= DICE_NUM;j++)
					pro[1 - flag][i] += pro[flag][i - j];//�������������У���ǰ�����6��ĺ�
			}
			flag = 1 - flag; //�����������
		}
		double total = 1.0;
		for(int i = 0;i < num;i++)
			total = total * (double)DICE_NUM;
		for(int i = num;i <= num * DICE_NUM;i++){
			double fre = (double)pro[flag][i]/total;
			System.out.format("num : %-3d  frequency : %f\n",i,fre);
		}
	}
	public static void main(String[] args){
		printFrequency(5);
	}
}
