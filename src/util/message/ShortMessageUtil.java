package util.message;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class ShortMessageUtil {

	/**
	 * 发送短信
	 * 
	 * @param shortMessageInfo
	 *            短信相关配置信息
	 * @throws HttpException
	 * @throws IOException
	 */
	public ShortMessageResult send(ShortMessageInfo shortMessageInfo) throws HttpException,
			IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("gbk".equals(shortMessageInfo.getCharset())?"http://gbk.sms.webchinese.cn":"http://utf8.sms.webchinese.cn");
		post.addRequestHeader(
				"Content-Type",
				"application/x-www-form-urlencoded;charset="
						+ shortMessageInfo.getCharset());// 在头文件中设置转码
		NameValuePair[] data = {
				new NameValuePair("Uid", shortMessageInfo.getUid()), // 注册的用户名
				new NameValuePair("Key", shortMessageInfo.getKey()), // 注册成功后,登录网站使用的密钥
				new NameValuePair("smsMob", shortMessageInfo.getSmsMob()), // 手机号码
				new NameValuePair("smsText", shortMessageInfo.getSmsText()) };// 设置短信内容
		post.setRequestBody(data);
		// 发送
		client.executeMethod(post);
		int statusCode = post.getStatusCode();
		ShortMessageResult result = new ShortMessageResult();
		result.setStatusCode(statusCode);
		String code = new String(post.getResponseBodyAsString().getBytes(
				shortMessageInfo.getCharset()));
		String message = "";
		switch (Integer.parseInt(code)) {
		case -1:
			message = "没有该用户账户";
			break;
		case -2:
			message = "密钥不正确（不是用户密码）";
			break;
		case -3:
			message = "短信数量不足";
			break;
		case -11:
			message = "短信内容出现非法字符";
			break;
		case -14:
			message = "手机号码为空";
			break;
		case -41:
			message = "短信内容为空";
			break;
		case -42:
			message = "短信发送数量";
			break;
		default:
			message = "发送成功";
			break;
		}
		result.setMessage(message);
		post.releaseConnection();
		return result;
	}
}
