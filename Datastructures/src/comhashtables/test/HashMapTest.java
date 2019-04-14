package comhashtables.test;

import com.hashtables.HashMap;
import com.hashtables.HashtableNode;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap testHashMap = new HashMap(10); // by default the load factor will be 0.75
		
		testHashMap.put("one",1);
		testHashMap.put("two",2);
		testHashMap.put("three",3);
		testHashMap.put("four",4);
		testHashMap.put("five",5);
		testHashMap.put("six",6);
		testHashMap.put("seven",7);
		//Size Will grow size=8,(can be confirmed from debugger)
		testHashMap.put("eight",8);
		
		System.out.println("Getting Node 8");
		HashtableNode result = testHashMap.get("eight");
		System.out.println("Node Key:"+result.getKey()+" Value:"+result.getValue());
		
		// Size will shrink, size=7 (can be confirmed from debugger)
		testHashMap.remove("eight");
		result = testHashMap.get("eight");
		if(result==null) {
			System.out.println("Since node with key:one was removed, so we got null");
			
		}

		
		System.out.println("Resizing should happen now, removeing more now");
		
		testHashMap.remove("seven");
		testHashMap.remove("six");
		testHashMap.remove("five");
		// Size will shrink,size=3 (can be confirmed from debugger)
		testHashMap.remove("four");
		
		
		
		
	}

}
