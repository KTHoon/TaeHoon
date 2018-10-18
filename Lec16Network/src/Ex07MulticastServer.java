import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Ex07MulticastServer {
	public static void main(String[] args) {
		DatagramPacket packet=null;
		MulticastSocket socket= null;
		
		try {
			socket=new MulticastSocket();
			System.out.println("서버 생성 성공");
		
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(System.in));
			
			//192.168.10.2 IPv4
			//A Class : 0000 :0.0.0.0~127.255.255.255 	->N.H.H.H
			//B Class : 1000 :128.0.0.0~191.255.255.255 ->N.N.H.H
			//C Class : 1100 :192.0.0.0~224.255.255.255 ->N.N.N.H
			//D Class : 1110 :224.0.0.0~240.255.255.255 ->N/A Multicast IP 대역
			//E Class : 1111 :240.0.0.0~255.255.255.255 ->연구용 예약된 번호
			InetAddress address=InetAddress.getByName("224.128.1.5");
			while(true) {
				System.out.print("입력 : ");
				String msg = reader.readLine();
				if(msg==null) {
					break;
				}
				packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,address,9006);
				socket.send(packet);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
