
public abstract class MessageSender {
	String title;	//제목
	String senderName; //보낸사람
	
	//MessageSender(){}
	MessageSender(String title,String senderName){
		this.title= title;
		this.senderName=senderName;
	}
	//메세지를 전송한다.
	abstract void sendMessage(String recipient);//추상메서드
}
