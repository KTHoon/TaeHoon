//JavaBean,VO(Value Object),Model,DTO   ->데이터 표현을 위한 클래스를 부르는 명칭.
//JavaBean - 멤버필드는 정보 은닉이 필요(private),get/set의 사용,디폴트 생성자 명시.
//Class 예제
public class Person 
{	
	//클래스,필드,생성자,메소드 전부 접근제한자를 붙일수 있음.
	//                             (같은 폴더내의 클래스만 가능)
	//접근제한자  public > protected > default > private(클래스 내에서만 가능)
	//			   (범용)	(같은 패키지,같은 폴더내의 클래스만 사용가능,상속관계는 가능)

	//필드(상태,데이터표현,Field,변수:Variable), 인스턴스 필드
	 String name;
	 int age;
	private char gender;
	private String phone;
	
	//default Constructor -->기본 생성자.
	public Person() {}
	//생성자 --> 멤버필드의 초기화 목적,
	//변수의 사용목적을 명확하게 하기위해
	public Person(String name,int age) {
		this.name=name;
		this.age=age-1;
	}
	public Person(String name,int age,char gender,String phone) {
		this(name,age);
		/*this.name=name;
		this.age=age;*/
		this.gender=gender;
		this.phone=phone;
	}
	public String getName() { //이름 정보를 얻어 반환
		return name;
	}
	public void setName(String name) {//이름 정보를 입력 받음
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//메서드
/*	public void setName(String name){
		this.name=name;
	}
	//리턴타입
	public String getName(){
		return name;
	}
	public void setAge(int age){
		if(age<0||age>120) {
			System.out.println("잘못 입력하심.");
			this.age=0;
		}else {
		this.age=age;
		}
	}
	//리턴타입
	public int getAge(){
		return age;
	}
	public void setGender(char gender){
		this.gender=gender;
	}
	public char getGender(){
		return gender;
		}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}*/
	
}
