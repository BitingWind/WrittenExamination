package huaweiOJ;
import java.util.*;
public class FindColors {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int n = scan.nextInt();
			int max = 0;
			int[] colorsNum = new int[n];
			//�ҵ����ֵ
			for(int i = 0; i < n; i++){
				int num = scan.nextInt();
				colorsNum[i] = num;
				if(max < num){
					max = num;
				}
			}
			int ceil = 1;
			//���ֵ��λ�� max < 2^num
			int num;
			for( num = 1; num < 32; num++){
				ceil = ceil *2;
				if(max < ceil) break;
			}
			//�ж���������ÿһλ�Ƿ���㣬����Ϊ�㣬����Ҫ��λ������
			boolean[] location = new boolean[num];
			for(int i = 0; i < num; i++){
				for(int j : colorsNum){
					if(location[i])break;
					//�жϵ�iλ�Ƿ�Ϊ1������
					if(!((j & 0x01 << i) ==0))
						location[i] = true;
				}
			}
			//ͳ�Ʒ���λ�ĸ���
			int result = 0; 
			for(boolean bool : location)
				if(bool) result++;
			//��������Ϸ����������ֱ�Ӱ�����ȡ����ֱ����ķ���
			if(result > n)
				result = n;
			System.out.println(result);
		}
	}
}
