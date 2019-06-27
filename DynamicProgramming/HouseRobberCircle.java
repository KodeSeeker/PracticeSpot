/**
The idea is fundamentally same as House Robber 1. 
However, here we make sure to not use the first house and last house together, since looting them together triggers an alarm!
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] withFirstHouse = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] withLastHouse = Arrays.copyOfRange(nums, 1, nums.length);
        // return Math.max(houseRobber1(withFirstHouse), houseRobber1(withLastHouse));
        return Math.max(houseRobber1(nums, 0, nums.length -2), houseRobber1(nums, 1, nums.length -1));

    }    
     public int houseRobber1(int[] nums){
        if(nums.length == 0) return 0;
        int first = nums[0];
        if(nums.length == 1) return first;
        int second = Math.max(first, nums[1]);
        int maxLoot = second;
        // pretty similar pattern to fibonacci
        for(int i = 2; i < nums.length; i++){
            maxLoot = Math.max(nums[i] + first, second);
            first = second;
            second = maxLoot;
        }
        return maxLoot;
    }
    
    //This approach just has modified indices to account for shifted indices
    public int houseRobber1(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int first = nums[start];
        if(end - start == 1) return first;
        int second = Math.max(first, nums[start +1]);
        int maxLoot = second;
        // pretty similar pattern to fibonacci
        for(int i = start + 2; i <= end; i++){
            maxLoot = Math.max(nums[i] + first, second);
            first = second;
            second = maxLoot;
        }
        return maxLoot;
    }
}
