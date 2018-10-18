import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02File {
	public static void main(String[] args) throws IOException {
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
		String today= dateFormat.format(new Date());
		
		File parent = new File("/home/pc15/io/",today);
		
		if(parent.exists()) {
			System.out.println("해당 디렉토리가 존재");
		}else {
			System.out.println("해당 디렉토리가 없음");
			if(parent.mkdirs()) {
				System.out.println(parent.getPath()+"디렉토리 생성 완료.");
			}else {
				System.out.println(parent.getPath()+"디렉토리 생성 실패.");
			}
		}
		//파일 만들기
		File file = new File(parent,"sample2.txt");
		
		if(file.exists()){
			System.out.println(file.getPath()+"해당 파일이 존재");
		}else {
			System.out.println(file.getPath()+"해당 파일이 존재 XXX");
			if(file.createNewFile()) {
				System.out.println(file.getPath()+"파일 생성 성공");
			}
			file.setReadOnly(); //읽기 전용파일로 만듬.
		}
			
		
	}
}
