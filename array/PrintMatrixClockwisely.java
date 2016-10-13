package array;

public class PrintMatrixClockwisely {
	public static void print(int[][] a) throws IllegalArgumentException {
		if(a == null) throw new IllegalArgumentException("The Matrix is NULL !!");
		int M = a.length;
		int N = a[0].length;
		int start = 0;
		while( M > 2 * start && N > 2 * start){
			printCircle(a,M,N,start);
			start++;
		}
	}
	private static void printCircle(int[][] a,int rows,int columns,int start){
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		for(int i = start;i <= endX;i++){
			System.out.println(a[start][i]);
		}
		if(start < endY){//��ʵfor�������жϣ�ֻ�Ƕ�Ӧ����Ľṹ
			for(int i = start + 1;i <= endY;i++){
				System.out.println(a[i][endX]);
			}
		}
		if(start < endY && start < endX){//������
			for(int i = endX - 1;i >= start;i--){
				System.out.println(a[endY][i]);
			}
		}
		if(start < endX && start < endY-1){//������
			for(int i = endY -1;i >= start + 1;i--){
				System.out.println(a[i][start]);
			}
		}
		
	}
	public static void main(String[] args){
		int[][] a = new int[][]{
			{1,2,5,8,9},
			{4,5,25,7,2},
			{3,2,1,4,7},
			{2,1,4,7,5},
			{1,2,6,11,7}
		};
		print(a);
	}
}
