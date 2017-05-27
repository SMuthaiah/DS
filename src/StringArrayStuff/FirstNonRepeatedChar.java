package StringArrayStuff;

import java.util.Hashtable;

/*Find a 1st non-repeated char in the string for 
 * e.g. if string is "Salesforce is the best company to work for” returns 'l'
 */

public class FirstNonRepeatedChar {

	public static char FirstNonRepeatableChar(String s){
		
		char[] charArray = s.toCharArray();
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		int count = 1; 
		char ret='0';
		
		for(Character c:charArray){
			
			if(ht.containsKey(c)){
				ht.put(c,count++);
			}
			else{
				ht.put(c, count);
			}
		}
		
		for(Character c: ht.keySet()){
			
			if(ht.get(c) == 1){
				ret=c;
			}
		}

		return ret;
		
	}
	
	public static void main (String args[]){

		System.out.println(FirstNonRepeatableChar("Salesforce is the best company to work for"));
	
	}
	
}
