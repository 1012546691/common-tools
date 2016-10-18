package util.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * json��ʽ����תΪ����
 * @author nagsh
 * @version 1.0
 */
public class Json2Object {


	/**
	 * ��json����(ֻ��һ��ֵ)תΪjavabean
	 * @param json �� {"password":"aaa","username":"admin"}
	 * @param ObjectClass Ҫת�Ķ����class
	 * @return
	 */
	public Object getObjectFromJSONObject(String json,Class ObjectClass) {  
		Object object = new Object();
		JSONObject jsonObject = JSONObject.fromObject(json);
		object=JSONObject.toBean(jsonObject,ObjectClass);
		return object;
	}
    /**
     * ��json����(ֻ��һ��ֵ)תΪmap
     * @param json �� {"password":"aaa","username":"admin"}
     * @return
     */
	public Map<String, ?> getMapFromJSONObject(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��������
		JSONObject object = JSONObject.fromObject(json);
		for (Object k : object.keySet()) {
			Object v = object.get(k);
			map.put(k.toString(), v);
		}
		return map;
	}
	
	/**
	 *  ��json����תΪmap �ڲ���Ƕ��
	 * @param json ��:{"height":1,"width":1,"location":[{ "����":"3"},{"�ײ�":"1" },{"���":"2" },{ "�Ҳ�":"1"},{"����":"4" }],
     *                  "type":[{"1":"1"},{"2":"2" },{"3":"4" },{"4":"4"}]}
	 * @return
	 */
    public Map<String, Object> getMappFromJSONObject2(String json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // ��������
        JSONObject object = object = JSONObject.fromObject(json);
        for (Object k : object.keySet()) {
            Object v = object.get(k);
            map.put(k.toString(), v);
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        //�ڶ������ �ڶ�������� Ҳ���ܲ���
        for(Map.Entry<String, Object> entry:map.entrySet()){
            try {
            	org.json.JSONArray array = new org.json.JSONArray(entry.getValue().toString());  //�ж��Ƿ���json����

                //��json����
                for (int i = 0; i < array.length(); i++) {
                    org.json.JSONObject object2 = array.getJSONObject(i);//json�������
                    JSONObject object3 = JSONObject.fromObject(object2.toString());  //json����
                    for (Object k : object3.keySet()) {
                        Object v = object3.get(k);
                        map2.put(k.toString(), v);
                    }
                }
            } catch (Exception e) {  //����json������
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

	/**
	 * ��json����תΪlist
	 * @param json ��:[{"password":"aaa","username":"admin"},{"password":"bbb","username":"sa"}]
	 * @param ObjectClass Ҫת�Ķ����class
	 * @return
	 */
	public List<?> getListFromJsonArray(String json,Class ObjectClass) {    
		JSONArray array = JSONArray.fromObject(json);
		List<?> list=(List<?>)JSONArray.toList(array,ObjectClass);
		return list;
	}
	/**
	 * ��json����תΪlist
	 * @param json ��:"[{\"personId\":\"1\",\"user\":{\"password\":\"aaa\",\"username\":\"admin\"}},{\"personId\":\"2\",\"user\":{\"password\":\"bbb\",\"username\":\"sa\"}}]";
	 * @param className Ҫת�Ķ����class
	 * @param classMap ��Ա��javabean��class
	 * @return
	 */
	public List<?> getListFromJsonArray(String json,Class className,Map<String, Class> classMap) {  
		List<?>  list = new ArrayList();
		JSONArray jsonArray = JSONArray.fromObject(json);
		list = JSONArray.toList(jsonArray,
				className, classMap);
		return list;
	}
}
