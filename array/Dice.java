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
		for(int i = 1; i <= DICE_NUM;i++) //设置，色子总数为1时的各点数出现次数，0抛弃
			pro[flag][i] = 1;
		for(int k = 2;k <= num;k++){
			for(int i = 1;i < k;i++){     //色子数为k时，k以下不会出现，故置零
				pro[1 - flag][i] = 0;
			}
			for(int i = k;i <= k * DICE_NUM;i++){
				pro[1 - flag][i] = 0;     //将要更新的点数出现次数置为零，重新计算
				for(int j = 1;j <= i && j <= DICE_NUM;j++)
					pro[1 - flag][i] += pro[flag][i - j];//等于另外数组中，其前面最多6项的和
			}
			flag = 1 - flag; //交替更新数组
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
