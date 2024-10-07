import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

class Solution {
    public int quicksort(List<Integer>nums,int k){
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for(int num:nums){
            if (num>pivot){
                big.add(num);
            }
            else if(num==pivot){
                equal.add(num);
            }
            else small.add(num);
        }
        if(k<=big.size()){
            return quicksort(big,k);
        }
        // else if(k>nums.size()-small.size()){
        //     return quicksort(small,k - nums.size() + small.size());
        // }
        // return pivot;
        else if(k<=big.size()+equal.size()) return pivot;
        else return quicksort(small,k-big.size()-equal.size());

    }
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numlist = new ArrayList<>();
        for(int num:nums){
            numlist.add(num);
        }
        return quicksort(numlist,k);
    }

    public static void main(String[] args) {
        int []nums = {3,2,1,5,6,4};
        System.out.println(new Solution().findKthLargest(nums,2));
    }
}