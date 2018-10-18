import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex11PritnWriter {
	public static void main(String[] args) throws IOException {
		//PrintWriter writer =new PrintWriter(System.out,true);
		PrintWriter writer =new PrintWriter(new FileWriter("/home/pc15/io/print.txt"),true);
		
		writer.println(">>> 개인정보 출력 <<<");
		writer.printf("%s %d %c %s \n","이름",12,'F',"전");
		writer.printf("%s %d %c %s \n","그림자",12,'M',"화");
		writer.printf("%s %d %c %s \n","그놈",24,'M',"번호우");
		
		//writer.flush();
		
		System.out.println(">>> 데이터 출력완료. <<<");
	}
}
