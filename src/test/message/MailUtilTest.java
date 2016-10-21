package test.message;

import util.message.MailInfo;
import util.message.MailUtil;

public class MailUtilTest {

	public void sendTextMail(){
		MailInfo mailInfo = new MailInfo();
		mailInfo.setMailSmtpHost("smtp.qq.com");
		mailInfo.setMailSmtpPort("465");
		mailInfo.setMailTransportProtocol("smtp");
		mailInfo.setMailSmtpSslEnable(true);
		mailInfo.setMailSmtpAuth(true);
		mailInfo.setUserName("����������");
		mailInfo.setPassword("����");  //qq����Ϊ��Կ
		mailInfo.setFromAddress("����������");
		mailInfo.setToAddress("����������1;����������2");
        mailInfo.setSubject("���Ը���");
        mailInfo.setSupportHtml(true);
        mailInfo.setContent("<h1>javamail����html��ʽ </h1>");
        String fileName[] = {"E:/HTTP_1.1_US.pdf","E:/HTTP_1.1_CN.pdf"};
        mailInfo.setAttachFileNames(fileName);
        MailUtil mailUtil = new MailUtil();
		try {
			mailUtil.sendMail(mailInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MailUtilTest test = new MailUtilTest();
		test.sendTextMail();
	}

}
