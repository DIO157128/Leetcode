import java.util.TreeMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int ans = 0;
        int maxCnt = 0;
        int []map = new int[128];
        char[] cs= s.toCharArray();
        for(int right =0;right<cs.length;right++){
            char c = cs[right];
            map[c]++;
            if(map[c]>maxCnt)maxCnt=map[c];
            while(right-left+1-maxCnt>k){
                map[cs[left++]]--;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "BAAAB";
        System.out.println(new Solution().characterReplacement(a,2));
    }
}