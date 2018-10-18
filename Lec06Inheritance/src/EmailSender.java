
public class EmailSender extends MessageSender{
	
	String senderAddr;
	String emailBody;
	
	EmailSender(String title,String senderName,String senderAddr,String emailBody){
		super(title,senderName);
		this.senderAddr=senderAddr;
		this.emailBody = emailBody;
	}

	@Override
	void sendMessage(String recipient) {
		System.out.println("======이메일 전송======");
		System.out.println("제  목:" + title);
		System.out.println("발신자:" + senderName);
		System.out.println("수신자:" +recipient );
		System.out.println("발신자 이메일 주소:" + senderAddr);
		System.out.println("이메일 내용:" + emailBody);
		System.out.println();
	}
}
