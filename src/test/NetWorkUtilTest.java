package test;

import util.NetWorkUtil;

public class NetWorkUtilTest {

	public static void main(String[] args) {
		//�Ƿ�������ӵ�����
		System.out.println(NetWorkUtil.isConnectOuterNet());
		//�Ƿ�������ӵ�ָ������
		System.out.println(NetWorkUtil.isConnectNet("www.hao123.com"));

	}

}
