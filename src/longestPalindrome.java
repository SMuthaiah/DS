import java.util.*;


class longestPalindrom {
	
	
	public static int checkLongestPalin(String data){
		
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		int count = 1;
		char charArray[] = data.toCharArray();
		int max = 0;
		int oddCount = 0;
		int oddCountValue=0;
		int returnnumber = 0;
		
		//Add the values in the hashtable
		for(int i=0; i<charArray.length;i++){
			
			if(ht.containsKey(charArray[i])){
				ht.put(charArray[i], ht.get(charArray[i])+1);
			}
			else{
			ht.put(charArray[i], count);
			}
		}
		
		
		for(Character c : ht.keySet()){
			
			
			if(ht.get(c)%2!=0){
				
				max = Math.max(max, ht.get(c));
				oddCountValue = oddCountValue + ht.get(c);
				oddCount++;
				
			}
			else{
			returnnumber = returnnumber + ht.get(c);
			}
		}	
		
		if(oddCount > 1){
		returnnumber = returnnumber + max  + ((oddCountValue - max) -(oddCount -1));
		}
		else{
			returnnumber = returnnumber + max;
		}
		System.out.println("longest is " + returnnumber);
		return returnnumber;
		
	}
	
	public int simpleCheck(String data){
		
		HashSet<Character> hs = new HashSet<Character>();
		char[] charArray = data.toCharArray();
		int count = 0;
		
		for(int i=0; i<charArray.length; ++i){
			
			if(hs.contains(charArray[i])){
				hs.remove(charArray[i]);
				count ++;
			}
			else{
				hs.add(charArray[i]);
			}	
		}
		if(!hs.isEmpty()){
			return count*2+1;
		}
		return count*2;
	}
	
	public static void main(String args[]){
		
		checkLongestPalin("abccccdd");
		
	}
	
	
}
