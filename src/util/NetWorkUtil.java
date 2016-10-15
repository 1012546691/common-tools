package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ������ع�����
 * @author nagsh
 * @version 1.0
 * @since 2016-10-15
 */
public class NetWorkUtil {
	 //������ַ
	 private static String address = "www.baidu.com";
	/**
	 * ping ��ַ �ж��Ƿ����pingͨ
	 * @param address Ҫping�ĵ�ַ
	 * @return true:����pingͨ  false:ping��ͨ
	 */
	 private static boolean isConnect(String address){
	    	boolean connect = false;
	    	Runtime runtime = Runtime.getRuntime();
	    	Process process;
			try {
				process = runtime.exec("ping " + address);
				InputStream is = process.getInputStream(); 
		        InputStreamReader isr = new InputStreamReader(is); 
		        BufferedReader br = new BufferedReader(isr); 
		        String line = null; 
		        StringBuffer sb = new StringBuffer(); 
		        while ((line = br.readLine()) != null) { 
		            sb.append(line); 
		        } 
		        is.close(); 
		        isr.close(); 
		        br.close(); 

		        if (null != sb && !sb.toString().equals("")) { 
		            String logString = ""; 
		            if (sb.toString().indexOf("TTL") > 0) { 
		                // ���糩ͨ  
		            	connect = true;
		            } else { 
		                // ���粻��ͨ  
		            	connect = false;
		            } 
		        } 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	        return connect;
	    }

	 /**
	  * �Ƿ�������ӵ�����.
	  * Ĭ��ping��www.baid.com
	  * @return
	  */
	 public static boolean isConnectOuterNet(){
		 return isConnect(address);
	 }
	
	 /**
	  * �Ƿ�������ӵ�ָ������.
	  * ���ٶȵ��պ���Ե��ô˷���
	  * @param address ��Ч��������ַ
	  * @return
	  */
	 public static boolean isConnectNet(String address){
		 return isConnect(address);
	 }
}
