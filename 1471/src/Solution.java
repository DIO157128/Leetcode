import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(int)(arr.length-1)/2];
        int left = 0;
        int right = arr.length-1;
        int[] ans = new int[k];
        int cnt = 0;
        while(k-->0){
            if(mid-arr[left]<=arr[right]-mid){
                ans[cnt++] = arr[right--];
            }
            else{
                ans[cnt++] = arr[left++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr= {-7,22,17,3};
        System.out.println(Arrays.toString(new Solution().getStrongest(arr, 2)));
    }
}