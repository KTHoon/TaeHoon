import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberMain2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<HashMap<String, Object>> memberList = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {			
			// 객체 생성
			HashMap<String, Object> member = new HashMap<String, Object>();
			
			System.out.print("이름 : ");
			member.put("name", reader.readLine());
			
			System.out.print("나이 : ");
			member.put("age", Integer.parseInt(reader.readLine()));
			
			System.out.print("성별 : ");
			member.put("gender", (char)reader.read());
			reader.readLine();
			
			System.out.print("전화번호 : ");
			member.put("phone", reader.readLine());
			
			System.out.print("우편번호 : ");
			member.put("zipcode", reader.readLine());
			
			memberList.add(member);
		}
		
		System.out.println("====== 회원목록 출력 ======");
		System.out.println("이름  나이  성별  전화번호");
		
		for(int i = 0; i < memberList.size(); i++) {
			HashMap<String, Object> member = memberList.get(i);
			System.out.printf("%s  %d  %c  %s\n", 
					member.get("name"), member.get("age"), member.get("gender"),
					member.get("phone")
					);
		}

	}
}

//http://exerd.com/update





