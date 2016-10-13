/*
 * ʵ�ֿ⺯����Integer.parseInt(String arg) 
 * ��Ҫ˼�룺����ѭ�����ɺ���ǰ���жϷǷ����룬������ֵ�����ۼ�
 * ע��㣺+ - �ŵ��ж� �Ƿ����ֵ��ж�
 * δ������⣺ �����ַ��� int�������������Max��С��MIN��
 * ������ ��ǰ����long����int ѭ���ڼ��жϣ�
 */
package string;

public class ParseInt {
	//private static String s;
	public static int parseInt(String str) throws Exception{
		if(str == null) throw new RuntimeException("String is NULL !");//����ָ��Ϊ null
		if(str.length() == 0)throw new Exception("String is NULL !"); //�ַ���Ϊ�� �� ���� 
		int N = str.length();
		boolean isNegetive = false;
		int result = 0;
		for(int i = N-1;i >= 0;i--){
			if(i == 0){         //��һλΪ ����λ����
				if(str.charAt(i) == '-'){   
					isNegetive = true;
					continue;
				}
				if(str.charAt(i) == '+')
					continue;
			}
			int numI = (int)str.charAt(i) - (int)'0';
			if(numI < 0 || numI > 9) //ĳһλ�а����������ַ�
				throw new Exception("The String is not a number !!");
			int power = 1;
			for(int j = 0;j < N-i-1;j++)
				power *= 10;
			result = result + numI * power;
		}
		if(isNegetive) result = result * -1;
		return result;
	}
	public static void main(String[] args){
		String s = "25";
		try{
			int num = parseInt(s);
			System.out.println(num);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
