package test.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.json.Json2Object;

public class Json2ObjectTest {

	public static void main(String[] args) {
		Json2Object o = new Json2Object();
		String json1 = "{\"password\":\"aaa\",\"username\":\"admin\"}";
		User user1= (User)o.getObjectFromJSONObject(json1,User.class);
		System.out.println(user1.getUsername());
		
		Map<String, String> map = (Map<String, String>) o.getMapFromJSONObject(json1);
		System.out.println(map.get("username"));
		
		String json4 = "{\"height\":1,\"width\":1,\"location\":[{ \"顶部\":\"3\"},{\"底部\":\"1\" },{\"左侧\":\"2\" },{ \"右侧\":\"1\"},{\"悬浮\":\"4\" }],\"type\":[{\"1\":\"1\"},{\"2\":\"2\" },{\"3\":\"4\" },{\"4\":\"4\"}]}";
		 Map<String, Object> map2 = o.getMappFromJSONObject2(json4);
	    for(Map.Entry<String, Object> entry:map2.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
	    
	    
		String json2 = "[{\"password\":\"aaa\",\"username\":\"admin\"},{\"password\":\"bbb\",\"username\":\"sa\"}]";
		List<User> list = (List<User>) o.getListFromJsonArray(json2, User.class);
		System.out.println(list.size());
		
		String json3 = "[{\"personId\":\"1\",\"user\":{\"password\":\"aaa\",\"username\":\"admin\"}},{\"personId\":\"2\",\"user\":{\"password\":\"bbb\",\"username\":\"sa\"}}]";
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("user",User.class);
		List<Person> persons = (List<Person>) o.getListFromJsonArray(json3, Person.class, classMap);
		System.out.println(persons.size());
		System.out.println(persons.get(0).getUser().getUsername());
		
		
	}

}
