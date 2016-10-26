package util.message;

public class ShortMessageInfo {
	private String uid;
	private String key;
	private String smsMob;
	private String smsText;
	private String charset = "utf-8";

	public String getUid() {
		return uid;
	}
    /**
     * 
     * @param uid 注册的用户名
     */
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getKey() {
		return key;
	}
    /**
     * 
     * @param key 接口秘钥(不是登录密码)
     */
	public void setKey(String key) {
		this.key = key;
	}

	public String getSmsMob() {
		return smsMob;
	}
    /**
     * 
     * @param smsMob 接收方手机号
     */
	public void setSmsMob(String smsMob) {
		this.smsMob = smsMob;
	}

	public String getCharset() {
		return charset;
	}
    /**
     * 
     * @param charset 编码格式
     */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSmsText() {
		return smsText;
	}
    /**
     * 
     * @param smsText 短信文本
     */
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

}
