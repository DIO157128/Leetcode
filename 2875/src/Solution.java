class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        for(int x:nums) total +=x;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        long sum = 0;
        for(int right = 0; right<n*2;right++){
            sum += nums[right%n];
            while(sum>target%total){
                sum -= nums[left%n];
                left++;
            }
            if (sum==target%total){
                ans = Math.min(ans,right-left+1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1:ans+(int) (target/total)*n;
    }
}