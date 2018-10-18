import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<String,String>();
		
		table.put("이산","010-1234-5678");
		table.put("설현","010-9876-5432");
		table.put("공유","010-4567-1239");
		table.put("현빈","010-7896-5421");
		
		//System.out.println("이산 번호: "+table.get("이산"));
		
		Enumeration<String> keys = table.keys();
		while(keys.hasMoreElements()) {
			String key=keys.nextElement();
			System.out.println(key+":"+table.get(key));
		}
	}
}
