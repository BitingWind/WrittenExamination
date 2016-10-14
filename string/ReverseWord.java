/*
 * 反转英文语句中的单词顺序！  
 * my story is beginning now.  -->
 *  now. beginning is story my 
 * 步骤，先对字符串所有字符反转，！
 * 再利用空格分隔string 分别进行反转！
 */
package string;

public class ReverseWord {
	public static String reverse(String s){
		if(s == null ) return null;
		if(s.length() == 0) return "";
		char[] sa = s.toCharArray(); //转化成char[]才能操作
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
				begin = end; //空格处理交给上个判断
			}
			else end++;
		}
		return new String(sa); //不可用 sa.toString();
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
