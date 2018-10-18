import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07BufferedReaderWriter {
	public static void main(String[] args) {
		BufferedReader reader =null;
		BufferedWriter writer =null;
		
		try {
			reader= new BufferedReader(new FileReader("src/Ex07BufferedReaderWriter.java"));
			writer= new BufferedWriter(new FileWriter("/home/pc15/io/Ex07BufferedReaderWriter.java"));
			
			while(true) {
				String str = reader.readLine();
				if(str==null) {
					break;
				}
				writer.write(str);	//writer.write(str+"\n");
				writer.newLine();
			}
			writer.flush();
			System.out.println("파일 입.출력 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null) reader.close();
				if(writer!=null) writer.close();
			}catch(IOException e) {}
		}
	}
}
