package huaweiOJ;

public class TurnChessPiece {
	private void LeftRight(int[][] A ,int x,int y){
        if(x == 0 || x == A[0].length - 1)
            return;
        int temp = A[y][x - 1];
        A[y][x - 1] = A[y][x + 1];
        A[y][x + 1] = temp;
    }
    private void UpDown(int[][] A ,int x,int y){
        if(y == 0 || y == A.length - 1)
            return;
        int temp = A[y - 1][x];
        A[y - 1][x] = A[y + 1][x];
        A[y + 1][x] = temp;
    }
    private void turn(int[][] A,int x,int y){
        LeftRight(A,x,y);
        UpDown(A,x,y);
    }
    public int[][] flipChess(int[][] A, int[][] f) {
        turn(A,f[0][1] - 1,f[0][0] - 1);
        turn(A,f[1][1] - 1,f[1][0] - 1);
        turn(A,f[2][1] - 1,f[2][0] - 1);
        return A;
    }
    public static void main(String[] args){
    	 TurnChessPiece t = new TurnChessPiece();
    	 int[][] a = new int[][]{
    		 {0,1,0,0},{1,0,1,0},
    		 {1,1,0,0},{1,0,0,1}
    	 };
    	 int[][] f = new int[][]{
    		 {2,3},{4,2},{2,3}
    	 };
    	 t.flipChess(a,f);
    }
}
