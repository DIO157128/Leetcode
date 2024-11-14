import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = arr.length-1;
        int toRemove = arr.length-k;
        while(toRemove-->0){
            if(x-arr[left]<=arr[right]-x){
                right--;
            }else {
                left++;
            }
        }
        for(int i = left;i<left+k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2,3,4,5};
        System.out.println(new Solution().findClosestElements(arr,7,3));
    }
}