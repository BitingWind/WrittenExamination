/*
 * �����ص㿼����double��������õĽ�����Ƚӽ������ģ�ԭ����������������Ľ����������
 * ���ܼ򵥵Ľ���ceil();��Ϊceil()�ǲ���ȫ�ģ�����floor()�Ľ�������ж���ѡ���Ƿ��1�����ǰ�ȫ�ġ�
 */
package huaweiOJ;
import java.util.*;
public class TableMove {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			float r = scan.nextInt();
			float x = scan.nextInt();
			float y = scan.nextInt();
			float x1 = scan.nextInt();
			float y1 = scan.nextInt();
			double dist = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
			double result = dist / 2 / r;
			int resultFloor = (int)Math.floor(result);
			if(result - resultFloor > 1E-6)
				resultFloor += 1;
		//	System.out.println((int)(Math.ceil(result)));
			System.out.println(result);
		}
	}
}
