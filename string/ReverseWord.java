/*
 * ��תӢ������еĵ���˳��  
 * my story is beginning now.  -->
 *  now. beginning is story my 
 * ���裬�ȶ��ַ��������ַ���ת����
 * �����ÿո�ָ�string �ֱ���з�ת��
 */
package string;

public class ReverseWord {
	public static String reverse(String s){
		if(s == null ) return null;
		if(s.length() == 0) return "";
		char[] sa = s.toCharArray(); //ת����char[]���ܲ���
		reverse(sa,0,sa.length - 1);
		int begin = 0;
		int end = 0;
		while(begin < sa.length){
			if(sa[begin] == ' '){
				begin++;
				end++;
			}
			else if(end == sa.length || sa[end] == ' '){
				reverse(sa,begin,end - 1);
				begin = end; //�ո������ϸ��ж�
			}
			else end++;
		}
		return new String(sa); //������ sa.toString();
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
		String s = "my story is beginning now.  ";
		s = reverse(s);
		System.out.println(s);
	}
}
