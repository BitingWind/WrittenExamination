/*
 * �������㣬��ΪInteger�ķ�ΧΪ2 * 1E10,LongΪ9* 1E19��Ŀ���� E18��Ȼ�����Ϊint
 * 
 */
package huaweiOJ;
import java.math.*; //Big�����ڰ�
import java.util.*;
public class Intestellar {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String numString = scan.next();
			BigInteger N = new BigInteger(numString);//�ַ�������
			double num = N.doubleValue();            //Big -> Double
			int sqrt = (int)Math.floor(Math.sqrt(num)); //���俪������ǰ��ѯ������ʱ��
			int result;
			for(result = sqrt; result > 0; result--){
				double re = (double)result;
				if(re * re + re <= num) break;
			}
			System.out.println(result);
		}
	}
}
