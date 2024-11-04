class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int curCost = 0;
        int ans = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){
            curCost+=Math.abs(cs[right]-ct[right]);
            while(curCost>maxCost){
                curCost-= Math.abs(cs[left]-ct[left]);
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
