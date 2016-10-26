package util.message;

import java.security.GeneralSecurityException;
import java.util.Properties;

import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 邮件信息
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
		// SSL加密
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
	 *            主机名
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
	 *            端口号,默认25
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
	 *            邮件协议名 默认smtp
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
	 *            邮件服务器是否需要身份认证,默认false
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
	 *            是否需要SSL加密,默认false
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
	 *            身份认证用户名
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
	 *            身份认证密码，qq邮箱需开启smtp并获取秘钥，此处为秘钥
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
	 *            发送人邮箱地址
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
	 *            接收人邮箱地址
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
	 *            标题
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
	 *            正文文本
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
	 *            是否支持html,默认false,即默认为纯文本文件，当为true是会anhtml方式解析文本
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
	 *            附件名称
	 */
	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

}
