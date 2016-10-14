/*
 * ��N * M�ķ����У��ɣ�1��1����������n,m���Ŀ�ѡ·����
 * ע�⣬ֻ�����һ��������ߣ���ĳ�߽��ֻ��һ��ѡ��
 * ���Ǹ���̬�滮�⣬��������ݹ飬�ݹ�洢���Լ�ѭ�������������
 */
package dynamicPrograming;

public class AimPathCount {
	//��򵥵ĵݹ�汾�����Ӷ�Ϊָ��ʱ��
	public static int countPath(int n,int m){
		if(n == 1 && m == 1) return 2;
		int result = 0;
		if(n == 1) result = result + 1 +countPath(n,m - 1);
		else if(m == 1) result = result + 1 + countPath(n - 1,m);
		else result = result + countPath(n - 1,m) + countPath(n, m - 1);
		return result;
	}
	//������������Ϊ �ݹ�Ĵ洢�汾��������Ľ�������ظ����㣬����ʽ��߽׸��Ӷ�(����Ϊƽ��)
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
	//��Ϊѭ��������֣��ɱ���ݹ��㷨��ɵ�ջ�ռ����ģ�ʱ��ΪN*M,�ռ�ΪN*M
	//Ӧ��һ�������ռ�������ķ�����ֻ�洢��λ������λ�õ�ֵ������
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
