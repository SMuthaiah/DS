import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class sortbyFreq {
	
	
	public static String FrequencyRearrange(String data){
		
		char[] charArray = data.toCharArray();
		Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
		
		int sizeofchararray = charArray.length;
		int count=0;
		
		for(int i=0; i<sizeofchararray;i++){
		
			char a = charArray[i];
			
			for(int j=0;j<sizeofchararray;j++){
				
				if(a == charArray[j])
					count++;
			}
			
			ht.put(count,String.valueOf(charArray[i]));
		}
		
		ArrayList<Integer> keyList = Collections.list(ht.keys());
		Collections.sort(keyList, Collections.reverseOrder());
		
		String returnString = "";
		
		for(int y=0;y<keyList.size();y++){
		returnString = returnString + ht.get(keyList.get(y));
		}
		
		return returnString;
	}
	
	public static void main(String args[]){
		
		System.out.println(FrequencyRearrange("Aabb"));
	}
	
	
	//O(n) implementation
	//1. Map the character as the key and the number of times it occurs as a value
	//2. build a char array with the index being the value from the map for that particular character(key)
	//3. Traverse the array from the end and append the string n number of time where n is the index. 
	
	public String frequencySort(String s) {
	    if (s == null) {
	        return null;
	    }
	    Map<Character, Integer> map = new HashMap();
	    char[] charArray = s.toCharArray();
	    int max = 0;
	    for (Character c : charArray) {
	        if (!map.containsKey(c)) {
	            map.put(c, 0);
	        }
	        map.put(c, map.get(c) + 1);
	        max = Math.max(max, map.get(c));
	    }

	    List<Character>[] array = buildArray(map, max);

	    return buildString(array);
	}

	private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet()) {
	        int count = map.get(c);
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	private String buildString(List<Character>[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = array.length - 1; i > 0; i--) {
	        List<Character> list = array[i];
	        if (list != null) {
	            for (Character c : list) {
	                for (int j = 0; j < i; j++) {
	                    sb.append(c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}
	
}
