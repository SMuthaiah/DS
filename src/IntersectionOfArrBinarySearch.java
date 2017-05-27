import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrBinarySearch {
	
	public int[] findIntersection(int[] nums1, int[] nums2){
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		int k = 0;
		Arrays.sort(nums2);
		for(Integer n: nums1){
			if(binarySearch(nums2,n))
				hs.add(n);
		}
		
		int[] returnArray = new int[hs.size()];
		for(Integer i : hs){
			
			returnArray[k++] = i;
			
		}
		
		return returnArray;
	}
	
	
	public boolean binarySearch(int[] nums,int target){
		
		int low = 0;
		int high = nums.length - 1;
		
		while(low<high){
			
			int mid = low + (high-low)/2;
			
			if(nums[mid] == target)
				return true;
			
			if(nums[mid] > target)
				high = mid - 1;
			
			if(nums[mid]<target)
				low = mid + 1; 
			
		}
		
		return false;
	}
	
}
