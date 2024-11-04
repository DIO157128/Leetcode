import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> mapP = new HashMap<>();
        Map<Character,Integer>mapS = new HashMap<>();
        int left = 0;
        char[]cs = s.toCharArray();
        char[]cp = p.toCharArray();
        for(int right = 0;right<cp.length;right++){
            mapP.merge(cp[right],1,Integer::sum);
        }
        for(int right = 0;right<cs.length;right++){
            mapS.merge(cs[right],1,Integer::sum);
            while(mapS.get(cs[right])>mapP.get(cs[right])){
                if(mapS.get(cs[left])==1) mapS.remove(cs[left]);
                else mapS.merge(cs[left],-1,Integer::sum);
                left++;
            }
            if (right -left+1 == cp.length){
                ans.add(left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Solution().findAnagrams(s,p));
    }
}