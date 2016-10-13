/*
 * 打印从1到n位最大数之间的所有数，
 * 注意：n不指定，说明很可能用int long会溢出
 * 为大数相关操作，用字符串表示
 */
package string;

public class BigNumber {
	public static void bigNumber(int n){
		char[] number = new char[n];
		int printFormat = 0;
		for(int i=0;i<n;i++)
			number[i] = '0';
		while(!increment(number)){
			printFormat++;
			if(printFormat == 20){
				printFormat = 0;
				System.out.println();
			}	
			printBigNumber(number);
		}
	}
	private static boolean increment(char[] a){
		boolean isOverFlow = false;
		int nTakeOver = 0;
		for(int i = a.length - 1;i >= 0;i--){
			int numI = (int)a[i] - (int)'0' + nTakeOver;
			if(i == a.length - 1) numI++;
			if(numI >= 10){//进位
				if(i == 0) isOverFlow = true;//第一位进位时，说明已完成全部
				else{
					nTakeOver = 1;
					a[i] = '0';
				}
			}
			else{
				a[i] = (char)('0' + numI);
				break; //如果不进位，不用继续循环
			}
		}
		return isOverFlow;
	}
	private static void printBigNumber(char[] a){
		boolean hasBeenBeginning = false;
		for(int i = 0;i < a.length;i++){
			if(a[i] != '0')
				hasBeenBeginning =true;
			if(hasBeenBeginning == true)
				System.out.print(a[i]);
		}
		System.out.print(" ");
	}
	public static void main(String[] args){
		bigNumber(6);
	}
}
