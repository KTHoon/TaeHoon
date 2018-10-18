import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class Ex05MultiChatServer {
	
	private static ArrayList<ClientThread> clientList = new ArrayList<>();
	class ClientThread extends Thread{
		
			
		Socket soc;
		PrintWriter writer;
		String nickName;
		ClientThread(Socket soc) {
			try {
				this.soc=soc;
				writer = new PrintWriter(soc.getOutputStream(),true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			//Client로 부터 수신한 메시지 -> 접속한 모든 Client에게 전송.
			try {
				BufferedReader reader 
					= new BufferedReader(new InputStreamReader(soc.getInputStream()));
				
				nickName=reader.readLine();
				sendAll("#"+nickName+"님이 입청하였습니다.");
				//클라이언트가 보낸 메시지 수신
				while(true) {
					String msg=reader.readLine();
					if(msg==null) {
						break;
					}
					//clientList.get(0).writer.println(msg);
					//모든 클라이언트에게 메시지 전송.
					sendAll(nickName+"님의 전언. : "+msg);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					sendAll(nickName+"님이 퇴청 하였습니다.");
					clientList.remove(this);
					if(soc!=null) soc.close();
				}catch(IOException e) {}
			}
		}
		public void sendAll(String msg) {
			for(ClientThread client:clientList ) {
				client.writer.println(msg);
			}
		}
	}
	
		public void start() {
			ServerSocket server=null;
			try {
				server=new ServerSocket(9002);
				System.out.println(">>> Server Ready");
			while (true) {
				// 클라이언트 대기
				Socket soc = server.accept();
				System.out.println("Client connect : " + soc.getRemoteSocketAddress());

				ClientThread client = new ClientThread(soc);
				clientList.add(client);
				client.start();
			}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		Ex05MultiChatServer obj=new Ex05MultiChatServer();
		obj.start();
	}
}
