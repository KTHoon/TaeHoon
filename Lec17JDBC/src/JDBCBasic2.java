import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import kr.or.nextit.jdbc.ConnectionFactory;
import kr.or.nextit.jdbc.ConnectionPool;
import kr.or.nextit.member.dao.MemberDao;
import kr.or.nextit.member.model.Member;

public class JDBCBasic2 {
	public static void main(String[] args) {
		
		//MemberDao memberDao = new MemberDao();
		MemberDao memberDao = MemberDao.getInstance();
		//#1.드라이버 로딩.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//ConnectionFactory connectioFactory=new ConnectionFactory();
		ConnectionFactory connectioFactory=ConnectionFactory.getInstance();
		
		ConnectionPool pool =ConnectionPool.getInstance();
		
		//#2.컨넥션 연결.
		Connection conn=null;
		String url="";
		String user="";
		String password="";
		
		String query="";
		Statement stmt=null;
		PreparedStatement pstmt=null;
		
		try {
			//conn=connectioFactory.getConnection(); //직접 연결
			conn=pool.getConnection();  //커넥션 풀에 대여
			System.out.println("DB 접속 성공");
			//회원 목록 조회
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(System.in));
			System.out.println("회원 아이디 검색 : ");
			
			String mem_id=reader.readLine();
			
			Member m=memberDao.selectMember(conn, mem_id);
			System.out.println(">>>>>검색 결과<<<<<");
			if(m!=null) {
			System.out.printf("%s , %s , %s , %s , %s , %s\n",
					m.getMem_id(),
					m.getMem_pwd(),
					m.getMem_name(),
					m.getMem_phone(),
					m.getMem_email(),
					m.getReg_date());
			}else {
				System.out.println("그런 아이디는 존재하지 않습니다.");
			}
			//회원 등록
			/*BufferedReader reader = 
					new BufferedReader(new InputStreamReader(System.in));*/
			Member mem=new Member();
			
			System.out.println("아이디 입력 : ");
			mem.setMem_id(reader.readLine());
	
			System.out.println("비밀번호 입력 : ");
			mem.setMem_pwd(reader.readLine());
			
			System.out.println("이름 입력 : ");
			mem.setMem_name(reader.readLine());
			
			System.out.println("전화번호 입력 : ");
			mem.setMem_phone(reader.readLine());
			
			System.out.println("이메일 입력 : ");
			mem.setMem_email(reader.readLine());
			
			int updCnt=memberDao.insertMember(conn, mem);
			System.out.println(updCnt+"명의 회원이 등록되었습니다.");
			
			//query="SELECT MEM_ID,MEM_PWD,MEM_NAME,MEM_PHONE,MEM_EMAIL,REG_DATE FROM TB_MEMBER";
			//PreparedStatment -> 기준쿼리를 만들어 조건이 수시로 변할때 변수값만 변함
			//Statement -> 컴파일 할 때 마다 where절의 값이 변경됨에 따라 다른 쿼리로 인식함
			
				//stmt=conn.createStatement();
				//ResultSet rs=stmt.executeQuery(query);//쿼리 실행
			
				//회원 목록 조회
				System.out.println(">>>>>>>>>> 회원 목록 출력 <<<<<<<<<<");
				List<Member> memberList=memberDao.selectMemberList(conn);
				
				for(Member member : memberList) {
					System.out.printf("%s , %s , %s , %s , %s , %s\n",
							member.getMem_id(),
							member.getMem_pwd(),
							member.getMem_name(),
							member.getMem_phone(),
							member.getMem_email(),
							member.getReg_date());
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//#3.SQL문 수행.
		finally {
			//#4.접속 해제
			try {
				//stmt.close(); 컨넥션이 끊어지면 자동으로 끊어짐 둘 다 쓸 경우 순서 중요!
				//if(conn !=null) conn.close();
				if(conn!=null)pool.releaseConnection(conn);  //커넥션 반납
			}catch(Exception e) {}
		}
		
	}
}
