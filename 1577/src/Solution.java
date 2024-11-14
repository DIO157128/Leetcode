import java.util.Arrays;

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        for(int num1:nums1){
            ans+=mul(num1*num1,nums2);
        }
        for(int num2:nums2){
            ans+=mul(num2*num2,nums1);
        }
        return ans;
    }
    public int mul(int pow,int[]nums){
        int j = 0;
        int k = nums.length-1;
        int ans = 0;
        while(j<k){
            int pro = nums[j]*nums[k];
            if(pro>pow){
                k--;
            }
            if(pro<pow){
                j++;
            }
            if(pro==pow){
                if(nums[j]==nums[k]){
                    ans+=(k-j+1)*(k-j)/2;
                    break;
                }
                int m=1,n=1;
                while(j<k&&nums[j+1]==nums[j]){
                    j++;
                    m++;
                }
                while(j<k&&nums[k]==nums[k-1]){
                    k--;
                    n++;
                }
                ans+=m*n;
                j++;
                k--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]nums1 ={4,1,4,1,12};
        int[]nums2 = {3,2,5,4};
        System.out.println(new Solution().numTriplets(nums1,nums2));
    }
}