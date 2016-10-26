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
		mailInfo.setUserName("发送人邮箱");
		mailInfo.setPassword("密码");  //qq邮箱为秘钥
		mailInfo.setFromAddress("发送人邮箱");
		mailInfo.setToAddress("接收人邮箱1;接收人邮箱2");
        mailInfo.setSubject("测试附件");
        mailInfo.setSupportHtml(true);
        mailInfo.setContent("<h1>javamail测试html格式 </h1>");
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
