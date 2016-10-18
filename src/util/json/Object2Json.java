package util.json;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ������ת��Ϊjson�ַ���.
 * @author nagsh
 * @version 1.0
 */
public class Object2Json {

	/**
	 * ��javabeanת��Ϊjson�����ʽ���ַ���.
	 * @param o javabean
	 * @return  json�����ʽ���ַ���
	 */
	public  String getJSONArrayFromObject(Object o) {
		JSONArray json = JSONArray.fromObject(o); 
		return json.toString();
	}
    /**
     * ��javabeanת��Ϊjson�����ʽ���ַ���.
     * @param o javabean
     * @return json�����ʽ���ַ���
     */
	public String getJSONObjectFromObject(Object o) {
		JSONObject jsonObj = JSONObject.fromObject(o);
		return jsonObj.toString();
	}
	/**
	 * ��listת��Ϊjson�����ʽ���ַ���
	 * @param list ArrayList
	 * @return n json�����ʽ���ַ���s
	 */
	public String getJSONArrayFromList(List<?> list) {
		JSONArray json = JSONArray.fromObject(list); 
		return json.toString();
	}
	/**
	 * ��listת��Ϊjson�����ʽ���ַ���
	 * @param list ArrayList
	 * @return json�����ʽ���ַ���
	 */
	public String getJSONObjectFromList(List<?> list) {
		JSONObject jsonObj = new JSONObject();
		for (int i = 0; i < list.size(); i++) {
			jsonObj.put(list.get(i).toString(), list.get(i));
		}
		return jsonObj.toString();
	}
	/**
	 * ��mapתΪjson�����ʽ���ַ���
	 * @param map HashMap
	 * @return json�����ʽ���ַ���
	 */
	public String getJSONArrayFromMap(Map<String,?> map) {
		JSONArray json = JSONArray.fromObject(map);
		return json.toString();
	}
	/**
	 * ��mapתΪjson�����ʽ���ַ���
	 * @param map HashMap
	 * @return json�����ʽ���ַ���
	 */
	public String getJSONObjectFromMap(Map<String,?> map) {
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
}
