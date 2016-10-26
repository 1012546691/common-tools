package test.message;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import util.message.ShortMessageInfo;
import util.message.ShortMessageResult;
import util.message.ShortMessageUtil;

public class ShortMessageUtilTest {

	public static void main(String[] args) {
		ShortMessageInfo shortMessageInfo = new ShortMessageInfo();
		shortMessageInfo.setUid("用户名");
		shortMessageInfo.setKey("接口秘钥");
		shortMessageInfo.setSmsMob("手机号");
		shortMessageInfo.setSmsText("信息文本");
		
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
 