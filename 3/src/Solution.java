import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int left = 0;
        int ans = 0;
        Set<Character> characters = new HashSet<>();
        for(int right=0;right<s.length();right++){
            char c = cs[right];
            while(characters.contains(c)){
                characters.remove(cs[left]);
                left++;
            }
            characters.add(c);
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}