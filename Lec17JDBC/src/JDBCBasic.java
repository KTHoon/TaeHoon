import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBasic {
	public static void main(String[] args) {
		//#1.드라이버 로딩.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//#2.컨넥션 연결.
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="java";
		String password="oracle";
		
		String query="";
		Statement stmt=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
			
			//회원 등록
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(System.in));
			System.out.println("아이디 입력 : ");
			String id = reader.readLine();
	
			System.out.println("비밀번호 입력 : ");
			String pwd=reader.readLine();
			
			System.out.println("이름 입력 : ");
			String name=reader.readLine();
			
			System.out.println("전화번호 입력 : ");
			String phone=reader.readLine();
			
			System.out.println("이메일 입력 : ");
			String email=reader.readLine();
			
			
			query= "INSERT INTO TB_MEMBER( "
			      +"MEM_ID,"
			      +"MEM_PWD,"
			      +"MEM_NAME,"
			      +"MEM_PHONE,"
			      +"MEM_EMAIL,"
			      +"REG_DATE"
			      +") VALUES ("
			      +" ?,"
			      +" ?,"
			      +" ?,"
			      +" ?,"
			      +" ?,"
			      +" SYSDATE "
			      +" ) ";
			pstmt=conn.prepareStatement(query);
			
			//데이터 바인딩.
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			pstmt.setString(3,name);
			pstmt.setString(4,phone);
			pstmt.setString(5,email);
			
			int updCnt=pstmt.executeUpdate();
			System.out.println(updCnt+"명의 회원이 등록되었습니다.");
			
			query="SELECT MEM_ID,MEM_PWD,MEM_NAME,MEM_PHONE,MEM_EMAIL,REG_DATE FROM TB_MEMBER";
			//PreparedStatment -> 기준쿼리를 만들어 조건이 수시로 변할때 변수값만 변함
			//Statement -> 컴파일 할 때 마다 where절의 값이 변경됨에 따라 다른 쿼리로 인식함
			
				stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query);//쿼리 실행
				//회원 목록 조회
				System.out.println(">>>>>>>>>> 회원 목록 출력 <<<<<<<<<<");
				while(rs.next()) {
					String mem_id=rs.getString("mem_id");
					String mem_pwd=rs.getString("mem_pwd");
					String mem_name=rs.getString("mem_name");
					String mem_phone=rs.getString("mem_phone");
					String mem_email=rs.getString("mem_email");
					String reg_date=rs.getString("reg_date");
					
					System.out.printf("%s\t %s\t  %s\t %s\t %s\t %s\n",mem_id,mem_pwd,mem_name,mem_phone,mem_email,reg_date);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//#3.SQL문 수행.
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			//#4.접속 해제
			try {
				//stmt.close(); 컨넥션이 끊어지면 자동으로 끊어짐 둘 다 쓸 경우 순서 중요!
				if(conn !=null) conn.close();
			}catch(SQLException e) {}
		}
		
	}
}
