package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 网络相关工具类.
 * @author nagsh
 * @version 1.0
 */
public class NetWorkUtil {
	 //外网地址
	 private static String address = "www.baidu.com";
	/**
	 * ping 地址 判断是否可以ping通.
	 * @param address 要ping的地址.
	 * @return true:可以ping通  false:ping不通.
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
		                // 网络畅通  
		            	connect = true;
		            } else { 
		                // 网络不畅通  
		            	connect = false;
		            } 
		        } 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	        return connect;
	    }

	 /**
	  * 是否可以连接到外网 默认ping的www.baidu.com.
	  * @return true 可以连接
	  *         false 无法连接
	  */
	 public static boolean isConnectOuterNet(){
		 return isConnect(address);
	 }
	
	 /**
	  * 是否可以连接到指定网络 当百度倒闭后可以调用此方法判断是否可以连接到外网. 
	  * @param address 有效的外网地址.
	  * @return true 可以连接
	  *         false 无法连接
	  */
	 public static boolean isConnectNet(String address){
		 return isConnect(address);
	 }
}
