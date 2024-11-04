import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        int maxNum = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int slow = 0;
        int fast = slow+k-1;
        int curLen = 0;
        for(int i =slow;i<=fast;i++){
            if(vowels.contains(s.charAt(i))){
                curLen+=1;
            }
        }
        maxNum = curLen;
        while(fast<=s.length()-2){

            if(!vowels.contains(s.charAt(slow))&&vowels.contains(s.charAt(fast+1))){
                curLen++;
            }

            if(vowels.contains(s.charAt(slow))&&!vowels.contains(s.charAt(fast+1))){
                curLen--;
            }
            maxNum = Math.max(curLen,maxNum);
            slow++;
            fast++;

        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("a",1));
    }
}
