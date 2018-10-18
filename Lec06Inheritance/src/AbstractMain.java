
public class AbstractMain {
	public static void main(String[] args) {
		SMSSender sms1 = new SMSSender("결제완료","GG","02-123-4567","빠른 배송");
		EmailSender email1 = new EmailSender("결제완료","GG", "master@ggst.co.kr", "총알 배송");
		
		SMSSender sms2 = new SMSSender("배송완료","GG","02-123-4567","환불X");
		EmailSender email2 = new EmailSender("배송완료","GG", "master@ggst.co.kr", "환불X");
	
		/*sms1.sendMessage("010-1234-5678");
		email1.sendMessage("Tat@naver.com");
		sms2.sendMessage("010-1234-5678");
		email2.sendMessage("Tat@naver.com");*/
		send(sms1,"010-1234-5678");
		send(email1,"tat@naver.com");
		send(sms2,"010-1234-5678");
		send(email2,"tat@naver.com");
	}
	public static void send(MessageSender ms , String recipient) {
		ms.sendMessage(recipient);
	}
}
