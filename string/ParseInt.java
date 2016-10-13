/*
 * 实现库函数：Integer.parseInt(String arg) 
 * 主要思想：利用循环，由后至前，判断非法输入，并对数值进行累加
 * 注意点：+ - 号的判断 非法数字的判断
 * 未解决问题： 输入字符串 int溢出！！（大于Max或小于MIN）
 * 方法？ 由前至后，long代替int 循环内加判断？
 */
package string;

public class ParseInt {
	//private static String s;
	public static int parseInt(String str) throws Exception{
		if(str == null) throw new RuntimeException("String is NULL !");//传入指针为 null
		if(str.length() == 0)throw new Exception("String is NULL !"); //字符串为空 即 “” 
		int N = str.length();
		boolean isNegetive = false;
		int result = 0;
		for(int i = N-1;i >= 0;i--){
			if(i == 0){         //第一位为 符号位！！
				if(str.charAt(i) == '-'){   
					isNegetive = true;
					continue;
				}
				if(str.charAt(i) == '+')
					continue;
			}
			int numI = (int)str.charAt(i) - (int)'0';
			if(numI < 0 || numI > 9) //某一位中包含非数字字符
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
