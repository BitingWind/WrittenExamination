/*
 * 动态规划DP：01背包问题，未做缓存设置优化
 * 输入物品价值与物品重量以及背包总可用重量，求可放置物品的最大价值和
 * 并输出物品集
 */
package dynamicPrograming;

public class Bag01 {
	public static int mostValue(int[] value,int[] weight,int C){
		//物品索引由1开始，V数组的[0][*]做初始值用，置0
		int[][] V = new int[value.length+1][C + 1];
		for(int i = 0; i <= value.length; i++)
			V[i][0] = 0;
		for(int j = 0; j <= C; j++)//索引到最大容量
			V[0][j] = 0;
		for(int i = 1; i <= value.length; i++){
			for(int j = 1; j <= C; j++){     //容量自底向上增加
				if(j < weight[i-1]) V[i][j] = V[i-1][j];//子问题条件1
				else {                                  //子问题条件2 决策！
					V[i][j] = max(V[i-1][j-weight[i-1]] + value[i-1],V[i-1][j]);
				}
			}
		}
		//由V数组从后向前遍历，依据添加条件，打印物品编号，索引由1开始
		int i = value.length;
		int j = C;
		while(i > 0 && j > 0){
			if(V[i][j] == (V[i-1][j - weight[i-1]] + value[i-1])){
				System.out.println(i);
				j = j - weight[i-1];
			}
			i--;
		}
	/*	for(int i = 0; i <= value.length; i++ ){
			for(int k : V[i])
				System.out.print(k + " ");
			System.out.println();
		}
	*/		
		return V[value.length][C];
	}
	private static int max(int a,int b){
		if(a > b)return a;
		else return b;
	}
	public static void main(String[] args){
		int[] w = new int[]{2,3,1,4,6,5};
		int[] v = new int[]{5,6,5,1,19,7};
		int capacity = 10;
		System.out.println(mostValue(v,w,capacity));
	}
}
