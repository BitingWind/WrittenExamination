/*
 * 在N * M的方格中，由（1，1）出发到（n,m）的可选路径！
 * 注意，只能向右或向下行走，到某边界后只有一种选择。
 * 这是个动态规划题，下面给出递归，递归存储，以及循环方法解决问题
 */
package dynamicPrograming;

public class AimPathCount {
	//最简单的递归版本，复杂度为指数时间
	public static int countPath(int n,int m){
		if(n == 1 && m == 1) return 2;
		int result = 0;
		if(n == 1) result = result + 1 +countPath(n,m - 1);
		else if(m == 1) result = result + 1 + countPath(n - 1,m);
		else result = result + countPath(n - 1,m) + countPath(n, m - 1);
		return result;
	}
	//下面两个函数为 递归的存储版本，已运算的结果不会重复计算，多项式最高阶复杂度(此题为平方)
	public static int countPathWithMemory(int n, int m){
		int[][] mem = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				mem[i][j] = -1;
		return countPathWithMemory(mem,n,m);
	}
	private static int countPathWithMemory(int[][] mem,int n,int m){
		if(mem[n][m] != -1) return mem[n][m];
		if(n == 1 && m == 1){
			mem[1][1] = 2;
			return 2;
		} 
		int result = 0;
		if(n == 1) result = result + 1 +countPath(n,m - 1);
		else if(m == 1) result = result + 1 + countPath(n - 1,m);
		else result = result + countPath(n - 1,m) + countPath(n, m - 1);
		mem[n][m] = result;
		return result;
	}
	//此为循环解决部分，可避免递归算法造成的栈空间消耗，时间为N*M,空间为N*M
	//应有一个常数空间解决问题的方法，只存储上位置与左位置的值？？？
	public static int countPathOnLoop(int n,int m){
		int[][] count = new int[n+1][m+1];
		count[1][1] = 2;
		for(int i = 1;i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(i == 1 && j == 1){
					System.out.print(count[i][j] + " ");
					continue;
				}
				else if(i == 1)
					count[i][j] = 1 + count[i][j - 1];
				else if(j == 1)
					count[i][j] = 1 + count[i - 1][j];
				else count[i][j] = count[i - 1][j] + count[i][j - 1];
				System.out.print(count[i][j] + " ");
			}
			System.out.println();
		}
		return count[n][m];
		
	}
	public static void main(String[] args){
		int n = 5;
		int m = 5;
		countPathOnLoop(n,m);
	/*	for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				System.out.print(countPath(i,j) + " ");
			}
			System.out.println();
		}*/
	}
}
