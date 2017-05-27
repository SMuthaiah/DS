
public class mergeSort {
	
	
	public static void split(int[] intArray, int low, int height){
		
		System.out.println("low value is " + low + "high value is: " + height);
		
		if(low < height){
			
			int middle = low + (height - low)/2;
			
			split(intArray,low,middle);
			split(intArray,middle+1,height);
			
		}
		
		
		
		
	}
	
	public static void main(String args[]){
		
		int[] a = {10,5,7,9,6};
		split(a,0,a.length-1);
	}

}
