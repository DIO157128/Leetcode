import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int ans = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){

            char c = cs[right];
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
            while(map.get(c)>2){
                if(map.get(cs[left])==1){
                    map.remove(cs[left]);
                }
                else{
                    map.put(cs[left],map.get(cs[left])-1);
                }
                left++;
            }

            ans = Math.max(ans,right-left+1);


        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLengthSubstring("bcbbbcba"));
    }
}