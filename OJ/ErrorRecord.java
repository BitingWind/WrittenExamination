package huaweiOJ;
import java.util.*;
public class ErrorRecord {
	static class Record{
		String name;
		int rowNum;
		int N;
		public Record(String name,int rowNum){
			this.name = name;
			this.rowNum = rowNum;
			N = 1;
		}
		public boolean equals(Object o){
			if(!(o instanceof Record))
				return false;
			else return this.name.equals(((Record)o).name) && (this.rowNum == ((Record)o).rowNum);
		}
		public String toString(){
			String nameSimple = name;
			if(name.length() > 16)
				nameSimple = name.substring(name.length()-16);
		    return nameSimple + " " + rowNum + " " + N;
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		List<Record> list = new LinkedList<Record>();
		int lineFlag = 0;
		while(scan.hasNextLine()){
			if(lineFlag == 8)break;
			
			String fullname = scan.next();
			int i= fullname.length() - 1;
			for(; i >= 0; i--){
				if(fullname.charAt(i) == '\\')
					break;
			}
			if(i == -1) i = 0;
			String name = fullname.substring(i + 1);
			int row = Integer.parseInt(scan.next());
			Record rec = new Record(name,row);
			if(list.contains(rec))
				list.get(list.indexOf(rec)).N++;
			else list.add(rec);
			
			lineFlag++;
		}
		LinkedList<Record> listSorted = new LinkedList<Record>();
		for(int i = 8; i>= 1; i--){
			for(Record r : list){
				if(r.N == i)
					listSorted.add(r);
			}
		}
		for(Record r : listSorted)
			System.out.println(r);
	}
}
