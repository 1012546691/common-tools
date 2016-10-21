package util.message;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class ShortMessageUtil {

	/**
	 * ���Ͷ���
	 * 
	 * @param shortMessageInfo
	 *            �������������Ϣ
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
						+ shortMessageInfo.getCharset());// ��ͷ�ļ�������ת��
		NameValuePair[] data = {
				new NameValuePair("Uid", shortMessageInfo.getUid()), // ע����û���
				new NameValuePair("Key", shortMessageInfo.getKey()), // ע��ɹ���,��¼��վʹ�õ���Կ
				new NameValuePair("smsMob", shortMessageInfo.getSmsMob()), // �ֻ�����
				new NameValuePair("smsText", shortMessageInfo.getSmsText()) };// ���ö�������
		post.setRequestBody(data);
		// ����
		client.executeMethod(post);
		int statusCode = post.getStatusCode();
		ShortMessageResult result = new ShortMessageResult();
		result.setStatusCode(statusCode);
		String code = new String(post.getResponseBodyAsString().getBytes(
				shortMessageInfo.getCharset()));
		String message = "";
		switch (Integer.parseInt(code)) {
		case -1:
			message = "û�и��û��˻�";
			break;
		case -2:
			message = "��Կ����ȷ�������û����룩";
			break;
		case -3:
			message = "������������";
			break;
		case -11:
			message = "�������ݳ��ַǷ��ַ�";
			break;
		case -14:
			message = "�ֻ�����Ϊ��";
			break;
		case -41:
			message = "��������Ϊ��";
			break;
		case -42:
			message = "���ŷ�������";
			break;
		default:
			message = "���ͳɹ�";
			break;
		}
		result.setMessage(message);
		post.releaseConnection();
		return result;
	}
}
