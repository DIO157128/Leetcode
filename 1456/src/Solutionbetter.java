import java.util.HashSet;
import java.util.Set;

public class Solutionbetter {
    public int maxVowels(String s, int k) {
        int maxNum = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int curLen = 0;
        for(int i =0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                curLen++;
            }
            if(i<k-1){
                continue;
            }
            maxNum = Math.max(maxNum,curLen);
            if(vowels.contains(s.charAt(i-k+1))){
                curLen--;
            }
        }
        return maxNum;
    }
}
