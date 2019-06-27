/**
Targeted search for a particular element in a rotated array. 
Consider test cases like [1,1,1,3,1] . Could degrade performance to O(n)
*/

class Solution {
    //See notes!
    //Worse case time complexity O(n). Malicious input with mostly dupes                        [1,1,1,3,1,1,1,1,1]
     //   3
    //Average (O(log n)
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length -1;
        while(s <= e){
            int m = (s+e)>>>1;
            //Key difference with dupes. Skip cases where s, m and e all point to same elem
            //Tricky case [1,2,1] target 1
            //Tricky case - [1,1,1,1,1,0,1] target 0
            while( s < e && nums[s] == nums[m] && nums[e] == nums[m]){ s++; e--;}
	   //Degrades to O(n) edge case -> [1,1,1,1,1] target- 3 	 	
           //System.out.println(" s" + s  + "  e"+ e + " m "+ m );

            if(nums[m] == target)
                return true;
            if(nums[m] <= nums[e]){//Diff 2
                if(target > nums[m] && target <=nums[e])
                    s = m+1;
                else 
                    e = m -1;
            } else {
                if(target >= nums[s] && target < nums[m])
                    e = m -1;
                else 
                    s = m + 1;
            }
        }
        return false;
    }
}
