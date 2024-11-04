import java.util.*;

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        ArrayList<ArrayList<Integer>>posLists = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            posLists.add(new ArrayList<>()) ;
        }
        for(int i =0;i<n;i++){
            int x = nums.get(i);
            posLists.get(x).add(i);
        }
        int ans = 0;
        for(List<Integer> posList:posLists){
            if(posList.size()<ans){
                continue;
            }
            int left = 0;
            for(int right=0;right<posList.size();right++){
                while(posList.get(right)-posList.get(left)-(right-left)>k){
                    left++;
                }
                ans = Math.max(ans,right-left+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        System.out.println(new Solution().longestEqualSubarray(nums,3));
    }
}