import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> stringMap = new HashMap<>();
        for(int k =minSize;k<=maxSize;k++){
            Map<Character,Integer> charMap = new HashMap<>();
            StringBuilder curString = new StringBuilder();
            for(int i =0;i<s.length();i++){
                char curChar = s.charAt(i);
                if(charMap.containsKey(curChar)){
                    charMap.put(curChar,charMap.get(curChar)+1);
                }
                else {
                    charMap.put(curChar,1);
                }
                curString.append(curChar);
                if(i<k-1){
                    continue;
                }
                if(charMap.size()<=maxLetters){
                    if(stringMap.containsKey(curString.toString())){
                        stringMap.put(curString.toString(),stringMap.get(curString.toString())+1);
                    }
                    else {
                        stringMap.put(curString.toString(),1);
                    }
                }
                if(charMap.get(curString.charAt(0))==1){
                    charMap.remove(curString.charAt(0));
                }
                else {
                    charMap.put(curString.charAt(0), charMap.get(curString.charAt(0))-1);
                }
                curString.deleteCharAt(0);
            }
        }
        int max = 0;
        for(String sm: stringMap.keySet()){
            max = Math.max(max,stringMap.get(sm));
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2, minSize = 3, maxSize = 4;
        System.out.println(new Solution().maxFreq(s,maxLetters,minSize,maxSize));
    }
}