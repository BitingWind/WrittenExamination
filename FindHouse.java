/* @copyright  bitingwind Sep 2017 
 *百度2017 笔试题
 * 在给定的网格中仅有0 1 两种元素，1代表该方格中有屋顶，
 * 每一个网格屋顶与其上下左右网格的网格相连，属同一个房子
 * 仅仅是对角不属于同一个房子，计算一个网格图中的房子数量。
 * 方法：采用深度优先搜索
 */
//package baidu;

public class FindHouse {
	private static int count;//静态变量
	public static int house(int[][] grid){
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] marked = new boolean[m][n];
		count = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				dfs(grid,marked,i,j,m,n,false); //遍历所有矩阵元素
			}
		}
		return count;
	}
	private static void  dfs(int[][] grid,boolean[][] marked,int x,int y,int m,int n,boolean hasCount){
		if(x >= m || x < 0 || y >= n || y < 0) return;
		if(marked[x][y] || grid[x][y] == 0) return;
		if(!hasCount){  //判断是否为第一个1，非首个1，其后均不造成结果影响
			hasCount = true;
			count++;
		}
		marked[x][y] = true; //先标记，以免进入递归死循环
		dfs(grid,marked,x - 1,y,m,n,hasCount);
		dfs(grid,marked,x + 1,y,m,n,hasCount);
		dfs(grid,marked,x,y + 1,m,n,hasCount);
		dfs(grid,marked,x,y - 1,m,n,hasCount);
			
	}
	public static void main(String[] args){
		int[][] grid = new int[][]{
			{1,0,1,1,0,1},
			{0,1,1,1,1,1},
			{0,0,0,1,0,0},
			{0,1,0,0,1,1},
		};
		System.out.println(house(grid));
	}
}
