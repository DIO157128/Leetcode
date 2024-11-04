import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int ans = 0;
        TreeMap<Integer,Integer> t = new TreeMap<>();
        for(int right =0;right<nums.length;right++){
            t.merge(nums[right],1,Integer::sum);
            int max = t.lastKey();
            int min = t.firstKey();
            while(max-min>limit){
                if(t.get(nums[left])==1) t.remove(nums[left]);
                else t.merge(nums[left],-1,Integer::sum);
                left++;
                max = t.lastKey();
                min = t.firstKey();
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {8,2,4,7};
        System.out.println(new Solution().longestSubarray(nums,4));
    }
}