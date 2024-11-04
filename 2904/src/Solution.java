class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int cnt = 0;
        int left = 0;
        String ans = s;
        String cur = "";
        char[] cs = s.toCharArray();
        for(int right = 0; right<cs.length;right++){
            char c = cs[right];
            cur+=c;
            cnt+=Character.getNumericValue(c);
            while(cnt - Character.getNumericValue(cs[left])>=k){
                cur = cur.substring(1);
                cnt -= Character.getNumericValue(cs[left++]);
            }
            if(cnt==k){
                if(cur.length()==ans.length()){
                    ans = ans.compareTo(cur)>0?cur:ans;
                }
                if(cur.length()<ans.length()){
                    ans = cur;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "100011001";
        int k =3;
        System.out.println(new Solution().shortestBeautifulSubstring(str,k));
    }
}