package test;

import util.NetWorkUtil;

public class NetWorkUtilTest {

	public static void main(String[] args) {
		//是否可以连接到外网
		System.out.println(NetWorkUtil.isConnectOuterNet());
		//是否可以连接到指定网络
		System.out.println(NetWorkUtil.isConnectNet("www.hao123.com"));

	}

}
