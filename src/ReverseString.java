import java.util.Stack;

public class ReverseString {

	public static String reverseStrings(String a){
		
		char[] charArray = a.toCharArray();
		Stack<String> charStack = new Stack<String>();
		String returnString="";
		
		if(a == null || a == "")	
			return "No String Available";
		
		for(int i=0; i<charArray.length;i++){
			charStack.push(String.valueOf(charArray[i]));
		}
		
		while (!charStack.isEmpty()){
			
		returnString = returnString + charStack.pop();	
		}	
		
		return returnString;
		//TimeComplexity would be o(n) and Space Complexity would be o(n)
	}
	
	public static String reverseStringInPlace(String b){
		
		int size = b.length();
		int half = b.length()/2;
		char[] charArray = b.toCharArray();
		
		for(int i=0; i<half;i++){
			
			char temp = charArray[i]; 
			charArray[i] = charArray[size-1-i];
			charArray[size-1-i] = temp;
			
			
		}
		
		return new String(charArray);
		
		//time complexity would be o(nlogn) , space o(1)
	}
	
	public static void main(String args[]){
		
		System.out.println(reverseStrings("hello"));
		System.out.println(reverseStringInPlace("world"));	
		
		
	}
	}
	
	
