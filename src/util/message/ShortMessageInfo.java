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
     * @param uid ע����û���
     */
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getKey() {
		return key;
	}
    /**
     * 
     * @param key �ӿ���Կ(���ǵ�¼����)
     */
	public void setKey(String key) {
		this.key = key;
	}

	public String getSmsMob() {
		return smsMob;
	}
    /**
     * 
     * @param smsMob ���շ��ֻ���
     */
	public void setSmsMob(String smsMob) {
		this.smsMob = smsMob;
	}

	public String getCharset() {
		return charset;
	}
    /**
     * 
     * @param charset �����ʽ
     */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSmsText() {
		return smsText;
	}
    /**
     * 
     * @param smsText �����ı�
     */
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

}
