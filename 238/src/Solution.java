class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []a = new int[nums.length];
        int []b = new int[nums.length];
        a[0] =1;
        b[0] =1;
        for(int i =1;i< nums.length;i++){
            a[i] = a[i-1]*nums[i-1];
            b[i] = b[i-1]*nums[nums.length-i];
        }
        int []ans = new int[nums.length];
        for(int i =0;i< nums.length;i++){
            ans[i] = a[i]*b[nums.length-1-i];
        }
        return ans;
    }
}