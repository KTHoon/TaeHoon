import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex04HashMap {
	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		
		map.put("Id","SAN");
		map.put("Name","이 산");
		map.put("Age",26); //auto boxing
		map.put("gender",'M'); //auto boxing
		map.put("Phone", "020-1234-5689");
		//KEY의 중복은 불가,같은 KEY는 마지막 값으로 변경,추가 X
		map.put("Name","설 현");
		//순서 X
		//System.out.println(map);
		
		System.out.println("Id : " + map.get("Id"));
		System.out.println("Id : " + map.get("Age"));
		
		//키값 가져오기
		Set<String> keySet = map.keySet();
		Iterator<String> itr=keySet.iterator();
		
		while(itr.hasNext()) {
			String key=itr.next();
			System.out.println(key+"="+map.get(key));
		}
		
		/*if(itr.hasNext()) {
			int size=keySet.size();
		for(int i=0; i<size; i++) {
			String key = itr.next();
			System.out.println(key);
		}
		}*/
		
		System.out.println("size() : " + map.size());
		System.out.println("size() : " + map.containsKey("Id"));
		System.out.println("size() : " + map.containsValue("020-1234-5689"));
		System.out.println("isEmpty : "+map.isEmpty());
		
	}
}
