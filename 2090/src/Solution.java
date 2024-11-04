public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        double curSum=0.0;
        int index = k;
        for(int i =0;i<nums.length;i++){
            if(i<k||i>=nums.length-k){
                avgs[i] = -1;
            }
            curSum+=nums[i];
            if(i<2*k){
                continue;
            }

            int avg = (int)Math.floor(curSum/(2*k+1));;
            avgs[index] = avg;
            index++;
            curSum-=nums[i-2*k];
        }
        return avgs;
    }

    public static void main(String[] args) {
        int[]nums = {7,4,3,9,1,8,5,2,6};
        for (int i:new Solution().getAverages(nums,3)){
            System.out.println(i);
        }

    }
}
