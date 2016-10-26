package util.message;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailUtil {
	Session session = null;
	Transport ts = null;

	/**
	 * 发送邮件
	 * @param mailInfo 邮件设置信息
	 * @throws Exception
	 */
	public void sendMail(MailInfo mailInfo) throws Exception {
		Properties prop = mailInfo.getProperties();
		// 1、创建session
		session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		try {
			// 2、通过session得到transport对象
			ts = session.getTransport();
			// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
			ts.connect(mailInfo.getMailSmtpHost(), mailInfo.getUserName(),
					mailInfo.getPassword());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(mailInfo.getFromAddress()));
		// 指明邮件的收件人
		String toAddress = mailInfo.getToAddress().replaceAll(";", ",");
		InternetAddress[] toList;
		try {
			toList = InternetAddress.parse(toAddress);
		} catch (Exception e) {
			throw new Exception("收件人格式错误,多个收件人请以\";\"隔开");
		}
		message.setRecipients(Message.RecipientType.TO, toList);
		// 邮件的标题
		message.setSubject(mailInfo.getSubject());
		// 邮件的文本内容
		Multipart multipart = new MimeMultipart();
		if (mailInfo.isSupportHtml()) {
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			multipart.addBodyPart(html);
		} else {
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mailInfo.getContent());
			multipart.addBodyPart(messageBodyPart);
		}

		try {
			if (mailInfo.getAttachFileNames() != null
					&& mailInfo.getAttachFileNames().length > 0) {
				String attachFileNames[] = mailInfo.getAttachFileNames();
				for (int i = 0; i < mailInfo.getAttachFileNames().length; i++) {
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					String fileName = attachFileNames[i];
					DataSource source = new FileDataSource(fileName);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(MimeUtility.encodeText(
							fileName, "utf-8", null));
					multipart.addBodyPart(messageBodyPart);
				}
			}
		} catch (Exception e) {
			throw new Exception("添加附件失败");
		}
		message.setContent(multipart);

		message.setSentDate(new Date());
		ts.sendMessage(message, message.getAllRecipients());
	}

}
