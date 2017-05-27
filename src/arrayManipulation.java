public class arrayManipulation {
    public static int removeDuplicates(int[] nums) {
        
        int a = nums.length;
        int totalCount=0 , repeatCount=0;
        
        
        for(int i=0; i<a;i++){
            
            if(i==0){
                totalCount++;
            }
            else{
                if(nums[i]==nums[i-1]){
                    repeatCount++;
                }
                else{
                    totalCount++;
                    if(nums[i] > nums[i-1]){
                    nums[i-1]= nums[i];
                    }
                }
            }
        }
        for(int k=0; k<nums.length; k++){
        System.out.println(nums[k]);
        }
        return totalCount;
    }
    
    
    public static int removeDuplicatesa(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for(int k=0; k<nums.length; k++){
            System.out.println(nums[k]);
            }
        return i + 1;
    }
    
    public static void main (String[] args){
        int b[] = {1,2,3,4};
        System.out.println("the total count is" + removeDuplicatesa(b));
    }
}