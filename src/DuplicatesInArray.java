
import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
	
	
	public List<Integer> findDup(int[] data){
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0 ; i<data.length; ++i){
			
			int value = Math.abs(data[i]) - 1;
			
			if(data[value] < 0){
				result.add(Math.abs(value));
			}
			
			data[value] = -data[value] ;
			
		}
		
		return result;
		
	}
	

}
