public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxNum = Integer.MIN_VALUE;
        double curSum = 0.0;
        for(int i =0;i<nums.length;i++){
            curSum+=nums[i];
            if(i<k-1){
                continue;
            }
            double average = curSum/k;
            maxNum = Math.max(maxNum,average);
            curSum = curSum-nums[i-k+1];

        }
        return maxNum;
    }

    public static void main(String[] args) {
        int []nums = {1,12,-5,-6,50,3};
        System.out.println(new Solution().findMaxAverage(nums,4));
    }
}
