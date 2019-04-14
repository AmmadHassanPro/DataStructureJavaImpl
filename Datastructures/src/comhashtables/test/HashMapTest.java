package comhashtables.test;

import com.hashtables.HashMap;
import com.hashtables.HashtableNode;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap testHashMap = new HashMap(10);
		
		
		testHashMap.put("one",1);
		testHashMap.put("two",2);
		testHashMap.put("three",3);
		testHashMap.put("four",4);
		testHashMap.put("five",5);
		testHashMap.put("six",6);
		testHashMap.put("seven",7);
		testHashMap.put("eight",8);
		
		System.out.println("Getting Node 1");
		HashtableNode result = testHashMap.get("one");
		System.out.println("Node Key:"+result.getKey()+" Value:"+result.getValue());
		
		
		
		
		
	}

}
