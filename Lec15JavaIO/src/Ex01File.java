import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Ex01File {
	public static void main(String[] args) throws IOException {
		
		//File file= new File("/home/pc15/io/sample.txt");//절대 경로 표현
		/*File file= new File("../sample.txt"); //상대 경로 표현
		
		System.out.println("getName() : "+file.getName());
		System.out.println("getAbsolutePath() : "+file.getAbsolutePath());
		System.out.println("getCanonicalPath() : "+file.getCanonicalPath());
		System.out.println("getPath() : " +file.getPath());
		System.out.println("getParent() : " +file.getParent());*/
		
		//루트 디렉토리 목록 가져오기.
		File[] roots =File.listRoots();
		System.out.println(roots[0]);
		
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("yyyy년 MM월 dd일 (E) HH:mm:ss");
		
		for(int i=0; i<roots.length; i++) {
			File root = roots[i];
			
			File[] files=root.listFiles();//하위 디렉토리를 가져옴
			for(File file:files) {
				//수정일자,유형,크기,파일명
				System.out.printf("%s\t %s\t %s\t %s\n",
						           dateFormat.format(file.lastModified())
						          ,file.isDirectory() ? "<DIR>" : "    "
						        	,(file.length()/1024)+"KB"
						        	,file.getName());
			}
		}
	}
}
