package util.message;

public class ShortMessageResult {
	private int statusCode;
	private String code;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * 
	 * @param statusCode
	 *            ����״̬��
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *            ��Ӧ��
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 *            ��Ӧ���Ӧ��Ϣ
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
