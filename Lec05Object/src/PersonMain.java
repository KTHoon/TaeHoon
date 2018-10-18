
public class PersonMain
{
	public static void main(String[] args)
	{
		//객체 생성
		Person p = new Person();//p: 객체 변수. Person(): 생성자
		//Person p = new Person("tat",25);//p: 객체 변수. Person(): 생성자
		//Person p = new Person("hoon",25,'M',"010-1234-5678");

		//p.name = "멍멍이";
		//p.age =25;
		//p.gender = 'M';
		//p.phone = "010-1239-4567~8";
		//System.out.println("이름: "+p.name);
		//System.out.println("나이: "+p.age);
		//System.out.println("성별: "+p.gender);
		//System.out.println("전화번호: "+p.phone);
		
		p.setName("이름");
		p.setAge(119);
		p.setGender('M');
		p.setPhone("010-7559-2123");
		System.out.println("이름 : "+p.getName());
		System.out.println("나이 : "+p.getAge());
		System.out.println("성별 : "+p.getGender());
		System.out.println("전화번호 : "+p.getPhone());
	
		Person p1 =new Person();
		Person p2 =new Person();
		
		p1.name = "ㅋㄹㅇㄷ";
		p2.name = "ㅊㄸㅇ";
		System.out.println("p1.name = "+p1.name);
		System.out.println("p2.nasme = "+p2.name);
	}
	
}
