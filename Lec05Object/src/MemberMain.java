import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberMain {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Member[] instanceList = new Member[2];
		for(int i=0; i<instanceList.length; i++) {
		
		//객체생성->없으면 NULL값이 들어
		//instanceList[i] = new Member();
		Member member = new Member();
		instanceList[i] = member;
		
		System.out.println("이름");
		instanceList[i].setName(reader.readLine());
		System.out.println("나이");
		instanceList[i].setAge(Integer.parseInt(reader.readLine()));
		System.out.println("성별");
		member.setGender((char)reader.read());
		reader.readLine();
		System.out.println("전화번호");
		instanceList[i].setPhone(reader.readLine());
		}
		System.out.printf("이름\t\t 나이\t\t 성별\t\t 전화번호\n");
		for(int i=0; i<instanceList.length; i++) {
		//Member member = instanceList[i];->만들어주면 값받을때 객체명으로 호출가능.
		System.out.printf("%s\t\t %d\t\t %c\t\t %s\t\t",instanceList[i].getName(),instanceList[i].getAge(),
				                                  instanceList[i].getGender(),instanceList[i].getPhone());
		System.out.println();
		}
	}	
}
