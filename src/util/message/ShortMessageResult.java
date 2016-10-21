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
	 *            请求状态码
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
	 *            响应码
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
	 *            响应码对应信息
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
