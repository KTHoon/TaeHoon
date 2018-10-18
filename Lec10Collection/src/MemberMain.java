import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberMain {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Member[] memberlist = new Member[2];
		ArrayList<Member> memberList=new ArrayList<Member>();
		
		for(int i=0; i<3; i++) {
		//객체생성->없으면 NULL값이 들어rka.
		Member member = new Member();
		memberList.add(member);
		
		System.out.println("이름");
		member.setName(reader.readLine());
		
		System.out.println("나이");
		member.setAge(Integer.parseInt(reader.readLine()));
		
		System.out.println("성별");
		member.setGender((char)reader.read());
		reader.readLine();
		
		System.out.println("전화번호");
		member.setPhone(reader.readLine());
		}
		
		System.out.printf("이름\t\t 나이\t\t 성별\t\t 전화번호\n");
		for(int i=0; i<memberList.size(); i++) {
			Member member =memberList.get(i);
		//Member member = memberlist[i];->만들어주면 값받을때 객체명으로 호출가능.
		System.out.printf("%s\t\t %d\t\t %c\t\t %s\t\t",member.getName(),member.getAge(),
				                                  member.getGender(),member.getPhone());
		System.out.println();
		}
	}	
}
