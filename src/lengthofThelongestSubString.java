import java.util.ArrayList;
import java.util.HashMap;

public class lengthofThelongestSubString {
	
	public int longestSS(String data){
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		char[] charArray = data.toCharArray();
		int count = 0;
		int max=0;
		//Just use Hashmap to find the place or index of the character in the array
		for(int i=0,j=0;i<charArray.length; ++i){

			if(hm.containsKey(charArray[i]))
			{
			j = Math.max(j, hm.get(charArray[i])+1);
			}
	
			hm.put(charArray[i],i);
			max = Math.max(max,i);
			
		}
		
		return max;
		
	}
	
	//Hashset Implementation
	public int lengthOfLongestSubstring(String s) {
	    if(s==null || s.length()==0){
	        return 0;
	    }
	 
	    int start=0;
	    int max = 0;
	 
	    HashSet<Character> set = new HashSet<Character>();
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(!set.contains(c)){
	            set.add(c);
	 
	            max = Math.max(max, i-start+1);
	        }else{
	            for(int j=start; j<i; j++){
	                set.remove(s.charAt(j));
	 
	                if(s.charAt(j)==c){
	                    start=j+1;
	                    break;    
	                }
	            }        
	 
	            set.add(c);
	        }
	    }
	 
	    return max;
	}
	
	public int[] validPalin(int x){
		
		int[] arr= null;
		int i;
		
		do { 
			arr[i] = x % 10; 
			x /= 10; 
			i++; 
			} while (x != 0); 
		
		return arr[];
	}
		
	
	
	
	public static void main (String args[]){
		
		String a = "hello";
		System.out.println(a.charAt(1));
	}
	
	
	

}
