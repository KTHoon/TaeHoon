import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ex05FileReaderWriter {
	public static void main(String[] args) {
		File source = new File("src/Ex05FileReaderWriter.java");
		File target = new File("/home/pc15/io/Ex05FileReaderWriter.java");
		
		FileReader reader =null;
		FileWriter writer =null;
		
		try{
			reader = new FileReader(source);
			writer = new FileWriter(target);
			
			char[] data = new char[256] ;
			while(true) {
				//int x = reader.read(); // 1char(2byte)씩 읽기.
				int x=reader.read(data);
				if(x==-1) break;
				
				writer.write(x); //1 char씩 쓰기.
				writer.write(data,0,x);
				//writer.flush();
			}
			System.out.println("파일 입*출력 완료");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null) reader.close();
				if(writer != null) writer.close();
			}catch(IOException e) {}
		}
	}
}
