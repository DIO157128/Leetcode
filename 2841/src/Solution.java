import java.util.*;

public class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long maxNum = 0;
        long curNum = 0;
        for(int i =0;i<nums.size();i++){
            if(!map.containsKey(nums.get(i))){
                map.put(nums.get(i),1);
            }
            else {
                map.put(nums.get(i), map.get(nums.get(i))+1);
            }
            curNum+= nums.get(i);
            if(i<k-1){
                continue;
            }
            if(map.size()>=m){
                maxNum = Math.max(maxNum,curNum);
            }
            curNum-=nums.get(i-k+1);
            if(map.get(nums.get(i-k+1))==1){
                map.remove(nums.get(i-k+1));
            }
            else {
                map.put(nums.get(i-k+1), map.get(nums.get(i-k+1))-1);
            }

        }
        return maxNum;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(3);
        System.out.println(new Solution().maxSum(nums,2,2));
    }

}
