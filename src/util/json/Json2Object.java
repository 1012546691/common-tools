package util.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * json格式数据转为对象
 * @author nagsh
 * @version 1.0
 */
public class Json2Object {


	/**
	 * 将json对象(只有一组值)转为javabean
	 * @param json 如 {"password":"aaa","username":"admin"}
	 * @param ObjectClass 要转的对象的class
	 * @return
	 */
	public Object getObjectFromJSONObject(String json,Class ObjectClass) {  
		Object object = new Object();
		JSONObject jsonObject = JSONObject.fromObject(json);
		object=JSONObject.toBean(jsonObject,ObjectClass);
		return object;
	}
    /**
     * 将json对象(只有一组值)转为map
     * @param json 如 {"password":"aaa","username":"admin"}
     * @return
     */
	public Map<String, ?> getMapFromJSONObject(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject object = JSONObject.fromObject(json);
		for (Object k : object.keySet()) {
			Object v = object.get(k);
			map.put(k.toString(), v);
		}
		return map;
	}
	
	/**
	 *  将json对象转为map 内部可嵌套
	 * @param json 如:{"height":1,"width":1,"location":[{ "顶部":"3"},{"底部":"1" },{"左侧":"2" },{ "右侧":"1"},{"悬浮":"4" }],
     *                  "type":[{"1":"1"},{"2":"2" },{"3":"4" },{"4":"4"}]}
	 * @return
	 */
    public Map<String, Object> getMappFromJSONObject2(String json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        JSONObject object = object = JSONObject.fromObject(json);
        for (Object k : object.keySet()) {
            Object v = object.get(k);
            map.put(k.toString(), v);
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        //第二层解析 第二层可能是 也可能不是
        for(Map.Entry<String, Object> entry:map.entrySet()){
            try {
            	org.json.JSONArray array = new org.json.JSONArray(entry.getValue().toString());  //判断是否是json数组

                //是json数组
                for (int i = 0; i < array.length(); i++) {
                    org.json.JSONObject object2 = array.getJSONObject(i);//json数组对象
                    JSONObject object3 = JSONObject.fromObject(object2.toString());  //json对象
                    for (Object k : object3.keySet()) {
                        Object v = object3.get(k);
                        map2.put(k.toString(), v);
                    }
                }
            } catch (Exception e) {  //不是json串数组
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

	/**
	 * 将json数组转为list
	 * @param json 如:[{"password":"aaa","username":"admin"},{"password":"bbb","username":"sa"}]
	 * @param ObjectClass 要转的对象的class
	 * @return
	 */
	public List<?> getListFromJsonArray(String json,Class ObjectClass) {    
		JSONArray array = JSONArray.fromObject(json);
		List<?> list=(List<?>)JSONArray.toList(array,ObjectClass);
		return list;
	}
	/**
	 * 将json数组转为list
	 * @param json 如:"[{\"personId\":\"1\",\"user\":{\"password\":\"aaa\",\"username\":\"admin\"}},{\"personId\":\"2\",\"user\":{\"password\":\"bbb\",\"username\":\"sa\"}}]";
	 * @param className 要转的对象的class
	 * @param classMap 成员中javabean的class
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
