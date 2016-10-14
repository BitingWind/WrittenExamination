package huaweiOJ;

public class VisitPath {
	public int countPath(int[][] map,int n,int m){
		int x = -1,y = -1;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] == 1){
					x = i;
					y = j;
					break;
				}
		if(x == -1 || y == -1) return 0;
		int result = 0;
		boolean[][] hasTra = new boolean[n][m];
		//hasTra[x][y] = true;
		result = travel(map,hasTra,x,y,0);
		return result;
	}
	private int travel(int[][] map,boolean[][] hasTra,int x,int y,int cur){
		if(x < 0 || x > map.length - 1 || y < 0 || y > map[0].length - 1)
			return cur;
		if(hasTra[x][y] == true) return cur;
		if(map[x][y] == -1)return cur;
		if(map[x][y] == 2){
			cur++;
			return cur;
		}
		hasTra[x][y] = true;
		cur = cur + travel(map,hasTra,x-1,y,cur)
				  + travel(map,hasTra,x+1,y,cur)
				  + travel(map,hasTra,x,y-1,cur)
				  + travel(map,hasTra,x,y+1,cur);
		return cur;
	}
	public static void main(String[] args){
		int[][] mapT = new int[][]{
			{0,1,0},{2,0,0}
		};
		VisitPath vp = new VisitPath();
		System.out.println(vp.countPath(mapT,2,3));
	}
}
