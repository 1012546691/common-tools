package test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.json.Object2Json;

public class Object2JsonTest {

	public static void main(String[] args) {
		Object2Json o = new Object2Json();
		List<User> list = new ArrayList();
		User user = new User();
		user.setUsername("admin");
		user.setPassword("aaa");
		User user2 = new User();
		user2.setUsername("sa");
		user2.setPassword("bbb");
		list.add(user);list.add(user2);
		//将对象转为json数组格式的字符串
		System.out.println(o.getJSONArrayFromObject(user));
		//将对象转为json对象格式的字符串
		System.out.println(o.getJSONObjectFromObject(user));
		//将list转为json数组格式的字符串
		System.out.println(o.getJSONArrayFromList(list));
		//将list转为json对象格式的字符串
		System.out.println(o.getJSONObjectFromList(list));
		Map<String,User> map = new HashMap();
		map.put("u1", user);
		map.put("u2", user2);
		System.out.println(o.getJSONArrayFromMap(map));
		System.out.println(o.getJSONObjectFromMap(map));
		Map<String,String> map2 = new HashMap();
		map2.put("username", "admin");
		map2.put("password", "aaa");
		System.out.println(o.getJSONArrayFromMap(map2));
		System.out.println(o.getJSONObjectFromMap(map2));
		
		
		
	}

}
