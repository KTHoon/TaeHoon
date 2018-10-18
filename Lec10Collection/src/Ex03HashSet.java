import java.util.HashSet;
import java.util.Iterator;

public class Ex03HashSet {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		//순서X,중복X
		set.add("김태훈");
		set.add("태");
		set.add("훈");
		set.add("텔라르");
		
		System.out.println(set.toString());//자동으로 toString
		if(set.contains("김태훈")){
			System.out.println("존재");
		}else{
			System.out.println("아메바");
		}
		int size=set.size();
		System.out.println("size = "+size);
		
		//반복자.
		Iterator<String> iter = set.iterator();
		/*while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}*/
		
		if(iter.hasNext()) {
			 size=set.size();
		for(int i=0; i<size; i++) {
			String name = iter.next();
			System.out.println(name);
		}
		}
	}
}
