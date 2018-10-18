import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Member implements Serializable{
	
	String name;
	int age;
	char gender;
	transient String phone; //직렬화 대상에서 제외.
	
	Member(String name,int age,char gender,String phone){
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.phone=phone;
	}
	
}

public class Ex09ObjectInOutStream {
	
	public static void main(String[] args) {
		ObjectInputStream ois =null;
		ObjectOutputStream oos=null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("/home/pc15/io/member.ser"));
			Member[] memberList = {
					new Member("이산",25,'M',"010-1234-5678"),
					new Member("설현",25,'F',"010-5678-1234"),
					new Member("태리",26,'F',"010-5432-9876")
			};
			//객체 직렬화
			for(int i=0; i<memberList.length; i++) {
				oos.writeObject(memberList[i]);
			}
			System.out.println(">>객체 출력 완료.");
			
			ois =new ObjectInputStream(new FileInputStream("/home/pc15/io/member.ser"));
			//객체 역직렬화(직렬화한 객체를 다시 객체화)
			
			
			while(true) {
				Member member=(Member)ois.readObject();
				System.out.printf("%s %d %c %s \n",member.name,member.age,member.gender,member.phone);
			}
			
		}catch (EOFException e) {
			System.out.println();
			System.out.println("객체 입력 완료");
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
				if(ois != null) ois.close();
			}catch(IOException e) {}
		}
	}
}
