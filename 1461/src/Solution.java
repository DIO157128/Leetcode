import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> stings = new HashSet<>();
        String sub = "";
        int correct = (int)Math.pow(2,k);
        for(int i =0;i<s.length();i++){
            sub+=s.charAt(i);
            if(i<k-1){
                continue;
            }
            stings.add(sub);
            sub = sub.substring(1);
        }
        return stings.size()==correct;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasAllCodes("00110110",2));
    }
}
