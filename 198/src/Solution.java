class Solution {
    public int rob(int[] nums) {
        int maxMoney = 0;
        int []dp = new int[nums.length];
        for(int i =0;i< nums.length;i++){
            if(i==0){
                dp[i] = nums[i];
            }
            else if(i==1){
                dp[i] = Math.max(nums[0],nums[1]);
            }
            else {
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            maxMoney = Math.max(maxMoney,dp[i]);
        }
        return maxMoney;
    }
}
