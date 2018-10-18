import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ex06Properties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		prop=System.getProperties(); //시스템 프로퍼티 정보
		prop.list(System.out);       //시스템 목록 출력.
		/*prop.setProperty("user_id", "san");
		prop.setProperty("user_nickname", "kingsan");
		
		System.out.println("user_id : "+ prop.getProperty("user_id"));
		System.out.println("user_nickname : "+ prop.getProperty("user_nickname"));*/
		
		//*.properties파일에서 프로퍼티 정보 읽어 오기.
		prop.load(new FileInputStream("src/application.properties"));
		String server =prop.getProperty("active.profile");
		System.out.println("서버 유형:"+server);
		
		String downloadDir= prop.getProperty("download.dir");
		System.out.println("다운로드 경로 : "+ downloadDir);
		
		String driver=prop.getProperty("driver");
		//class.forname(classname);//동적로딩
		String url=prop.getProperty("url");
		String user=prop.getProperty("user");
		String password=prop.getProperty("password");
		
		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("user: " + user);
		System.out.println("password: " + password);
		
		//XML파일로 저장.
		prop.storeToXML(new FileOutputStream("application.xml"),
				                  "Application Config", "UTF-8");
	}
}
