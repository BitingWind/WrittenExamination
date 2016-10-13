/*
 * ��ӡ��1��nλ�����֮�����������
 * ע�⣺n��ָ����˵���ܿ�����int long�����
 * Ϊ������ز��������ַ�����ʾ
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
			if(numI >= 10){//��λ
				if(i == 0) isOverFlow = true;//��һλ��λʱ��˵�������ȫ��
				else{
					nTakeOver = 1;
					a[i] = '0';
				}
			}
			else{
				a[i] = (char)('0' + numI);
				break; //�������λ�����ü���ѭ��
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
