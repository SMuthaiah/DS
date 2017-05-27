package StringArrayStuff;

/*You have a string aaabbdcccccf, transform it the following way => a3b2d1c5f1 
ie: aabbaa -> a2b2a2 not a4b2*/


public class printContFreqChar {
	
	
	public static String printFrequency(String s){
		
		if(s == null)
			return "empty string";
		
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=0,j=1;i<s.length();i++){
			
			if(j<s.length() && s.charAt(j) == s.charAt(i)){
				count++;
			}
			else{
				sb.append(s.charAt(i));
				sb.append(count);
				count = 1;
			}
			j++;
		}
		
		
		
		return sb.toString();
	}
	
	
	public static void main(String args[]){
		
		
		System.out.println(printFrequency("aabbcc"));
	}

}
