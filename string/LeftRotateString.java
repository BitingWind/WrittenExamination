/*
 * �����ַ���������num���ַ��ƶ����ַ���ĩβ��
 * ����������ת�����壬����num���ַ����Լ�ǰ����ַ���
 */
package string;

public class LeftRotateString {
	public static String rotate(String s,int num){
		if(s == null ) return null;
		if(s.length() == 0) return "";
		if(num < 0)return s;
		if(num > s.length()) num = s.length();
		char[] sa = s.toCharArray();
		reverse(sa,0,sa.length -1);
		reverse(sa,0,sa.length - 1 - num);
		reverse(sa,sa.length - num,sa.length - 1);
		return new String(sa);
	}
	private static void reverse(char[] s ,int i,int j){
		while(i < j){
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++; j--;
		}
	}
	public static void main(String[] args){
		String s = "abcdefg";
		s = rotate(s,10);
		System.out.println(s);
	}
}
