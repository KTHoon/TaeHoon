import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex08DataInOutStream {
	public static void main(String[] args) {

		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(new FileOutputStream("/home/pc15/io/data.dat"));
			
			int[] data= {10,20,23,24,28,32,35,39,-1,-2,-3};
			
			for(int i=0; i<data.length; i++) {
				dos.writeInt(data[i]);
			}
			System.out.println(">>데이터 출력 완료.");
			
			dis = new DataInputStream(new FileInputStream("/home/pc15/io/data.dat"));
			
			while(true) {
				try {
				int x = dis.readInt();
				 /*if(x==(data.length)-1) {
					break;
				}*/
				System.out.println(x);
				}catch(EOFException e){
					System.out.println("파일의 끝에 도달했습니다.");
					break;
				}
				
			}
			
/*			dos.writeInt(150);
			dos.writeShort(70);
			dos.writeDouble(3.141516);
			dos.writeBoolean(true);
			dos.writeUTF("문자열");
			System.out.println(">>데이터 출력 완료.");

			dis = new DataInputStream(new FileInputStream("/home/pc15/io/data.dat"));
			
			System.out.println("int : "+ dis.readInt());
			System.out.println("Short : "+ dis.readShort());
			System.out.println("Double : "+ dis.readDouble());
			System.out.println("Boolean : "+ dis.readBoolean());
			System.out.println("StingUTF : "+ dis.readUTF());*/
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) dos.close();
				if(dis != null) dis.close();
			} catch (IOException e) {
			}
		}
	}
}
