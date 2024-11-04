class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans =0;
        int sum = 0;
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            sum += nums[right];
            while(sum>=goal){
                if(sum ==goal){
                    ans++;
                }
                sum -=nums[left++];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(new Solution().numSubarraysWithSum(nums,2));
    }
}