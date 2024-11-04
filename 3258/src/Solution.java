class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int[]map = new int[2];
        int left = 0;
        int ans = 0;
        char[] cs= s.toCharArray();
        for(int right = 0;right<cs.length;right++){
            int rightIndex = cs[right]-'0';
            map[rightIndex]++;
            while(map[0]>k&&map[1]>k){
                int leftIndex = cs[left] - '0';
                map[leftIndex]--;
                left++;
            }
            ans += right - left +1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countKConstraintSubstrings("10101",1));
    }
}