class Solution {
    public boolean isLegal(char c){
        return Character.isLetter(c)||Character.isDigit(c);
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        char[]cs = s.toCharArray();
        while(left<right){
            while(!isLegal(cs[left])){
                left++;
            }
            while(!isLegal(cs[right])){
                right--;
            }
            if(Character.toLowerCase(cs[left])!=Character.toLowerCase(cs[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(s));
    }
}