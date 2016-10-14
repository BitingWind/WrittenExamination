/*
 * ��̬�滮DP��01�������⣬δ�����������Ż�
 * ������Ʒ��ֵ����Ʒ�����Լ������ܿ�����������ɷ�����Ʒ������ֵ��
 * �������Ʒ��
 */
package dynamicPrograming;

public class Bag01 {
	public static int mostValue(int[] value,int[] weight,int C){
		//��Ʒ������1��ʼ��V�����[0][*]����ʼֵ�ã���0
		int[][] V = new int[value.length+1][C + 1];
		for(int i = 0; i <= value.length; i++)
			V[i][0] = 0;
		for(int j = 0; j <= C; j++)//�������������
			V[0][j] = 0;
		for(int i = 1; i <= value.length; i++){
			for(int j = 1; j <= C; j++){     //�����Ե���������
				if(j < weight[i-1]) V[i][j] = V[i-1][j];//����������1
				else {                                  //����������2 ���ߣ�
					V[i][j] = max(V[i-1][j-weight[i-1]] + value[i-1],V[i-1][j]);
				}
			}
		}
		//��V����Ӻ���ǰ���������������������ӡ��Ʒ��ţ�������1��ʼ
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
