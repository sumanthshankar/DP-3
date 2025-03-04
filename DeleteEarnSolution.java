// Time Complexity : O(n) + O(MAX value in array)
// Space Complexity : O(MAX value in array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DeleteEarnSolution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i += 1) {
            max = Math.max(max, nums[i]);
        }
        
        int[] dp = new int[max + 1];
        
        for(int i = 0; i < nums.length; i += 1) {
            int index = nums[i];
            dp[index] = dp[index] + nums[i];
        }
        
        int skip = 0;
        int take = dp[0];
        
        for(int i = 1; i < dp.length; i += 1) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        
        return Math.max(skip, take);
    }
}