import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex10BytetoChar {
	public static void main(String[] args) throws IOException {
		InputStreamReader reader=null;
		OutputStreamWriter writer =null;
		
		
		File file = new File("/home/pc15/io/memo.txt");
		reader = new InputStreamReader(System.in);
		writer = new OutputStreamWriter(new FileOutputStream(file));
		
		System.out.println(">>> 메모를 남겨주세요 <<<");
		char[] cbuf =new char[256];
		while(true) {
			
			int len=reader.read(cbuf);
			if(len==-1) {
				System.out.println("키보드 연결을 끊습니다.");
				break;
			}
			writer.write(cbuf,0,len);
		}
		//writer.flush();  //close하면 자동으로 flush함
		System.out.println(">>>메세지 기록 완료 <<<");
		writer.close();
	}
}
