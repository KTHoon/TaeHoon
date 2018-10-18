import java.util.ArrayList;

public class Ex01ArrayList {
	public static void main(String[] args) {
		ArrayList<String> list= new ArrayList<String>();
		//<> : 제네릭 타입 한정(일반화.),1.5버전 이상가능.
		
		list.add("Today");
		list.add("Is");
		list.add(new String ("Bottle"));
		list.add(new String ("(llllll)ㅡ"));
        
		//list.add(new Integer(50));
		//System.out.println(list);
		
		list.add("Is"); //순서,중복가능
		//System.out.println(list);
		
		if(list.contains("Today")){ //존재여부 확인
			//System.out.println("있다.");
		}else { 
			//System.out.println("없다.");
			}
		
		/*if(list !=null && !list.isEmpty()) {
			int size=list.size();
		for(int i=0; i<size; i++) {
			//String name= (String)list.get(i);
			String name=list.get(i);
			System.out.println(i+":"+name);
		 }
		}*/
		//Advanced For,forEach , 1.5버전
		for(String name: list) {
			System.out.println(name);
		}
	}
}
