import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int cur = nums[i];
            if(!map.containsKey(cur)){
                map.put(cur,1);
            }
            else {
                int modify = map.get(cur)+1;
                map.put(cur,modify);
            }
        }
        int half = (nums.length+1)/2;
        for(int key:map.keySet()){
            if(map.get(key)>=half){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[]nums = {3,2,3};
        System.out.println(new Solution().majorityElement(nums));
    }
}