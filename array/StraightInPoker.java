/*
 * 随机抽出5张牌，判断是不是顺子，JQK为11 12 13 王牌可以表示所有牌，用零代替大小王
 * 步骤：建立一个数组存储每个牌的出现次数，遍历数组，计算相邻牌之间的《间隔数》
 * 判断标准：非王牌出现多次，必不为顺子
 *  		间隔数小于等于王牌数，为顺子，否则不是
 */
package array;

public class StraightInPoker {
	public static boolean isStraight(int[] a) throws IllegalArgumentException {
		if(a == null || a.length != 5)
			throw new IllegalArgumentException("You should get FIVE poker!!");
		int[] pokerNum = new int[14];
		for(int i = 0; i < pokerNum.length; i++)
			pokerNum[i] = 0;
		for(int i : a){
			if(i < 0 || i > 13) 
				throw new IllegalArgumentException("The number of pokers should locate in 0~13 !!");
			pokerNum[i]++;
		}
		int numOf0 = pokerNum[0];//王牌用零表示
		if(numOf0 > 2) throw new IllegalArgumentException("The trump is only 2 !!");
		int lastPoker = -1;
		int curPoker = -1;
		int sumOfInter = 0;
		for(int i = 1; i < pokerNum.length; i++){
			if(pokerNum[i] == 0) continue;
			if(pokerNum[i] > 1) return false;
			curPoker = i;
			if(lastPoker == -1) lastPoker = curPoker;//置前值
			else{
				sumOfInter += (curPoker - lastPoker - 1); //求间隔，必须减1 ！！！！！
				lastPoker = curPoker;
			}
		}
		if(sumOfInter <= numOf0) return true; //如果间隔小于等于王牌的数量，可以为顺子！
		else return false;
	}
	public static void main(String[] args){
		int[] pokers = new int[]{0,2,3,6,0};
		System.out.println(isStraight(pokers));
	}
}
