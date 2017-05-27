import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
	
public static int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> rs = new HashSet<Integer>();
       
        
        for(int i=0; i<nums1.length;++i){
            hs.add(nums1[i]);
        }
        
        for(int j=0;j<nums2.length;++j){
            if(hs.contains(nums2[j])){
                rs.add(nums2[j]);
            }
        }
        
        int[] resultarray=new int[rs.size()];
        
        if(rs.size()>0){
            Iterator<Integer> i = hs.iterator();
            int k=0;
            while(i.hasNext()){
                resultarray[k] = i.next();
            }
        }
        
        return resultarray;
        
    }


public static void main(String args[]){
	
	int[] a = {1,3,4,5};
	int[] b = {3,5};
	int[] toPrint = intersection(a,b);
	for(int i=0; i<toPrint.length;++i){
		
		System.out.println(toPrint[i]);
		
	}
	
}

}
