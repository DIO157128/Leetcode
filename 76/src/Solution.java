import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        int []mapT = new int[128];
        int []mapS = new int[128];
        StringBuilder str = new StringBuilder();
        StringBuilder ans = new StringBuilder(s);
        char[]cs = s.toCharArray();
        char[]ct = t.toCharArray();
        for(char c:ct){
            mapT[c]++;
        }
        int cntT = 0;
        for(int m:mapT){
            if (m>0) cntT++;
        }
        Set<Character> set = new HashSet<>();
        int left = 0;
        boolean bl = false;
        for(int right = 0;right<cs.length;right++){
            char cright = cs[right];
            str.append(cright);
            mapS[cright]++;
            if(mapT[cright]!=0&&mapS[cright]>=mapT[cright]){
                set.add(cright);
            }
            while(set.size()>=cntT){
                if(ans.length()>= str.length()&&set.size()==cntT){
                    bl = true;
                    ans.setLength(0);
                    ans.append(str);
                }
                char cleft = cs[left];
                mapS[cleft]--;
                if(mapS[cleft]<mapT[cleft]){
                    set.remove(cleft);
                }
                str.deleteCharAt(0);
                left++;
            }
        }
        return bl?ans.toString():"";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("a","a"));
    }
}