package array;

public class FirstSingleChar {
	public static char first(String s) throws IllegalArgumentException{
		if(s == null || s.length() == 0)
			throw new IllegalArgumentException("String is empty or null !!");
		int[] chars = new int[256];
		for(int i = 0;i < 256;i++)
			chars[i] = 0;
		for(int i = 0;i < s.length();i++)
			chars[(int)s.charAt(i)]++;
		for(int i = 0;i < s.length();i++){
			if(chars[(int)s.charAt(i)] == 1)
				return s.charAt(i);
		}
		throw new IllegalArgumentException("Has none single char !!");
	}
	public static void main(String[] args){
		String s = "abbagofhgrhogr";
		System.out.println(first(s));
	}
}
