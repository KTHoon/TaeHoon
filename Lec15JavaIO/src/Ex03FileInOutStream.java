import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03FileInOutStream {
	public static void main(String args[]) {
		
		File file = new File("/home/pc15/io/text.txt");
		
		//파일에 대한 입출력
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			//#1.스트림 연결(stream open)
			//fos= new FileOutputStream(file); //해당 파일이 없으면 자동 생성.
			fos= new FileOutputStream(file,true);//파일 뒤에 이어붙이기
			
			//#2.데이터 쓰기(write)
			fos.write('H');
			fos.write('E');
			fos.write('L');
			fos.write('L');
			fos.write('O');
			byte[] data = {' ','J','a','v','a',' '};
			fos.write(data);
			
			System.out.println("파일 쓰기 완료");
			//파일 읽기
			fis= new FileInputStream("src/Ex03FileInOutStream.java");
			
			//data=new byte[fis.available()];
			data=new byte[256];
			
			while(true) {
				//int x = fis.read(); // 1byte data
				int x = fis.read(data); //x = 읽어 들인 byte의 갯수
				if(x==-1) {
					System.out.println("파일 읽기 종료 : "+x);
					break;
				}
				//System.out.print((char) x);
				System.out.println(new String(data));
			}
			
		}catch(FileNotFoundException e) {//경로가 잘못되면 뜸.
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{  //무조건 실행(정상or비정상 이던)
			//#3.자원해제
			try {
				if(fos!=null) fos.close();
				if(fis !=null)fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
