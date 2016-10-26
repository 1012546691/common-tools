package util.json;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 将对象转换为json字符串.
 * @author nagsh
 * @version 1.0
 */
public class Object2Json {

	/**
	 * 将javabean转换为json数组格式的字符串.
	 * @param o javabean
	 * @return  json数组格式的字符串
	 */
	public  String getJSONArrayFromObject(Object o) {
		JSONArray json = JSONArray.fromObject(o); 
		return json.toString();
	}
    /**
     * 将javabean转换为json对象格式的字符串.
     * @param o javabean
     * @return json对象格式的字符串
     */
	public String getJSONObjectFromObject(Object o) {
		JSONObject jsonObj = JSONObject.fromObject(o);
		return jsonObj.toString();
	}
	/**
	 * 将list转换为json数组格式的字符串
	 * @param list ArrayList
	 * @return n json数组格式的字符串s
	 */
	public String getJSONArrayFromList(List<?> list) {
		JSONArray json = JSONArray.fromObject(list); 
		return json.toString();
	}
	/**
	 * 将list转换为json对象格式的字符串
	 * @param list ArrayList
	 * @return json对象格式的字符串
	 */
	public String getJSONObjectFromList(List<?> list) {
		JSONObject jsonObj = new JSONObject();
		for (int i = 0; i < list.size(); i++) {
			jsonObj.put(list.get(i).toString(), list.get(i));
		}
		return jsonObj.toString();
	}
	/**
	 * 将map转为json数组格式的字符串
	 * @param map HashMap
	 * @return json数组格式的字符串
	 */
	public String getJSONArrayFromMap(Map<String,?> map) {
		JSONArray json = JSONArray.fromObject(map);
		return json.toString();
	}
	/**
	 * 将map转为json对象格式的字符串
	 * @param map HashMap
	 * @return json对象格式的字符串
	 */
	public String getJSONObjectFromMap(Map<String,?> map) {
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
}
