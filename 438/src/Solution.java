import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> fixedFindAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> mapP = new HashMap<>();
        Map<Character,Integer>mapS = new HashMap<>();
        char[]cs = s.toCharArray();
        char[]cp = p.toCharArray();
        for(int right = 0;right<cp.length;right++){
            mapP.merge(cp[right],1,Integer::sum);
        }
        int k = cp.length;
        for(int i = 0;i <cs.length;i++){
            mapS.merge(cs[i],1,Integer::sum);
            if(i<k-1){
                continue;
            }
            if(mapS.equals(mapP)){
                ans.add(i-k+1);
            }
            if(mapS.get(cs[i-k+1])==1) mapS.remove(cs[i-k+1]);
            else mapS.merge(cs[i-k+1],-1,Integer::sum);
        }
        return ans;
    }
    public List<Integer> unfixedFindAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int []cnt = new int[128];
        int left = 0;
        char[]cs = s.toCharArray();
        char[]cp = p.toCharArray();
        for(int right = 0;right<cp.length;right++){
            cnt[cp[right]]++;
        }
        for(int right = 0;right<cs.length;right++){
            cnt[cs[right]]--;
            while(cnt[cs[right]]<0){
                cnt[cs[left++]]++;
            }
            if(right-left+1==cp.length){
                ans.add(left);
            }
        }
        return ans;
    }
}