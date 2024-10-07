class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] after = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            for(int j = i+1;j<temperatures.length;j++){
                if (temperatures[j]>temperatures[i]){
                    after[i] = j-i;
                    break;
                }
            }
        }
        return after;
    }

    public static void main(String[] args) {
        int[] temperature = {73,74,75,71,69,72,76,73};
        new Solution().dailyTemperatures(temperature);
    }
}