import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ex02URL {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com:443/index.html?user_name=san%user_pw=123456!");
		System.out.println("protocol : "+url.getProtocol());
		System.out.println("host : "+url.getHost());
		System.out.println("port : " +url.getPort());
		System.out.println("path : "+url.getPath());
		System.out.println("Query : "+url.getQuery());
		
		//URLConnection
		URLConnection connection = url.openConnection();
		
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while(true) {
			String str=reader.readLine();
			if(str==null) {
				break;
			}
			System.out.println(str);
		}
	}
}
