
public class FibonnaciLinear {
	
	public static int fiboLinear(int n){
		
		int f1=1;
		int answer = 0;
		
		if(n==0) return 0;
		
		while(f1<=n){
			
			answer = answer + f1;
			f1 ++ ;
			
		}
		
		return answer;
	}
	
	public static void main(String args[]){
		System.out.println(fiboLinear(5));	
		}
	

}
