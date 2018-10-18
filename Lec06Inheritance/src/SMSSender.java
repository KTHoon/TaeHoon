
public class SMSSender extends MessageSender {
	
	String returnPhoneNo;  //회신전화번호
	String message;		   //메세지.
	
	SMSSender(String title, String senderName,String returnPhoneNo,String message){
		super(title,senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message=message;
	}

	@Override
	void sendMessage(String recipient) {
		System.out.println("======문자 메세지를 전송======");
		System.out.println("제  목:" + title);
		System.out.println("발신자:" + senderName);
		System.out.println("수신자:" +recipient );
		System.out.println("메세지:" + message);
		System.out.println("회신번호:" + returnPhoneNo);
		System.out.println();
	}
	
	
	
}
