import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int ans = 0;
        while(i<=j&&power>=tokens[i]){
            while(i<=j&&power>=tokens[i]){
                power-=tokens[i++];
                ans++;
            }
            if(i<j) {
                power += tokens[j--];
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]tokens = {200,100,300,400};
        System.out.println(new Solution().bagOfTokensScore(tokens,200));
    }
}