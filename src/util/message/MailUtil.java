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
	 * �����ʼ�
	 * @param mailInfo �ʼ�������Ϣ
	 * @throws Exception
	 */
	public void sendMail(MailInfo mailInfo) throws Exception {
		Properties prop = mailInfo.getProperties();
		// 1������session
		session = Session.getInstance(prop);
		// ����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
		session.setDebug(true);
		try {
			// 2��ͨ��session�õ�transport����
			ts = session.getTransport();
			// 3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
			ts.connect(mailInfo.getMailSmtpHost(), mailInfo.getUserName(),
					mailInfo.getPassword());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// �����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress(mailInfo.getFromAddress()));
		// ָ���ʼ����ռ���
		String toAddress = mailInfo.getToAddress().replaceAll(";", ",");
		InternetAddress[] toList;
		try {
			toList = InternetAddress.parse(toAddress);
		} catch (Exception e) {
			throw new Exception("�ռ��˸�ʽ����,����ռ�������\";\"����");
		}
		message.setRecipients(Message.RecipientType.TO, toList);
		// �ʼ��ı���
		message.setSubject(mailInfo.getSubject());
		// �ʼ����ı�����
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
			throw new Exception("��Ӹ���ʧ��");
		}
		message.setContent(multipart);

		message.setSentDate(new Date());
		ts.sendMessage(message, message.getAllRecipients());
	}

}
