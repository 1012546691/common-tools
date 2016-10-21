package test.message;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import util.message.ShortMessageInfo;
import util.message.ShortMessageResult;
import util.message.ShortMessageUtil;

public class ShortMessageUtilTest {

	public static void main(String[] args) {
		ShortMessageInfo shortMessageInfo = new ShortMessageInfo();
		shortMessageInfo.setUid("�û���");
		shortMessageInfo.setKey("�ӿ���Կ");
		shortMessageInfo.setSmsMob("�ֻ���");
		shortMessageInfo.setSmsText("��Ϣ�ı�");
		
		ShortMessageUtil util = new ShortMessageUtil();
		try {
			ShortMessageResult result = util.send(shortMessageInfo);
			System.out.println(result.getMessage());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
 