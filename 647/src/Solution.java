public class Solution {
    public int countSubstrings(String s) {
        boolean [][]dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i =0;i<s.length();i++){
            for(int j =0;j<=i;j++){
                if( (i==j)|| ((i==j+1)&&(s.charAt(i)==s.charAt(j))) || (s.charAt(i)==s.charAt(j))&&dp[j+1][i-1]){
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(new Solution().countSubstrings(str));
    }
}
