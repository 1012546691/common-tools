package util.message;

import java.security.GeneralSecurityException;
import java.util.Properties;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * �ʼ���Ϣ
 * @author nagsh
 *
 */
public class MailInfo {
	private String mailSmtpHost;
	private String mailSmtpPort = "25";
	private String mailTransportProtocol = "smtp";
	private boolean mailSmtpAuth = false;
	private boolean mailSmtpSslEnable = false;
	private String userName;
	private String password;
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String content;
	private boolean supportHtml = false;
	private String[] attachFileNames;

	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailSmtpHost);
		p.put("mail.transport.protocol", this.mailTransportProtocol);
		p.put("mail.smtp.port", this.mailSmtpPort);
		p.put("mail.smtp.auth", this.mailSmtpAuth ? "true" : "false");
		// SSL����
		if (mailSmtpSslEnable) {
			MailSSLSocketFactory sf;
			try {
				sf = new MailSSLSocketFactory();
				sf.setTrustAllHosts(true);
				p.put("mail.smtp.ssl.enable", "true");
				p.put("mail.smtp.ssl.socketFactory", sf);
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}

		}
		return p;
	}

	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	/**
	 * 
	 * @param mailSmtpHost
	 *            ������
	 */
	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}

	public String getMailSmtpPort() {
		return mailSmtpPort;
	}

	/**
	 * 
	 * @param mailSmtpPort
	 *            �˿ں�,Ĭ��25
	 */
	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}

	public String getMailTransportProtocol() {
		return mailTransportProtocol;
	}

	/**
	 * 
	 * @param mailTransportProtocol
	 *            �ʼ�Э���� Ĭ��smtp
	 */
	public void setMailTransportProtocol(String mailTransportProtocol) {
		this.mailTransportProtocol = mailTransportProtocol;
	}

	public boolean isMailSmtpAuth() {
		return mailSmtpAuth;
	}

	/**
	 * 
	 * @param mailSmtpAuth
	 *            �ʼ��������Ƿ���Ҫ�����֤,Ĭ��false
	 */
	public void setMailSmtpAuth(boolean mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}

	public boolean isMailSmtpSslEnable() {
		return mailSmtpSslEnable;
	}

	/**
	 * 
	 * @param mailSmtpSslEnable
	 *            �Ƿ���ҪSSL����,Ĭ��false
	 */
	public void setMailSmtpSslEnable(boolean mailSmtpSslEnable) {
		this.mailSmtpSslEnable = mailSmtpSslEnable;
	}

	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 *            �����֤�û���
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            �����֤���룬qq�����迪��smtp����ȡ��Կ���˴�Ϊ��Կ
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * 
	 * @param fromAddress
	 *            �����������ַ
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	/**
	 * 
	 * @param toAddress
	 *            �����������ַ
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	/**
	 * 
	 * @param subject
	 *            ����
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	/**
	 * 
	 * @param content
	 *            �����ı�
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public boolean isSupportHtml() {
		return supportHtml;
	}

	/**
	 * 
	 * 
	 * @param supportHtml
	 *            �Ƿ�֧��html,Ĭ��false,��Ĭ��Ϊ���ı��ļ�����Ϊtrue�ǻ�anhtml��ʽ�����ı�
	 */
	public void setSupportHtml(boolean supportHtml) {
		this.supportHtml = supportHtml;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	/**
	 * 
	 * @param attachFileNames
	 *            ��������
	 */
	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

}
