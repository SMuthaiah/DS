
public class twoSum {
	
	    public int[] twoSum(int[] nums, int target) {
	        
	        
	        for(int i=0,j=1;i<nums.length;i++){
	            
	            if(nums[i] + nums[j] == target)
	            {
	            	int returnInt[] = {nums[i],nums[j]};
	                return  returnInt;
	            }
	            
	        }
	        
	        return null;
	    }
	
}
