class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowSize = cardPoints.length-k;
        int curSum = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i =0;i<cardPoints.length;i++){
            sum+=cardPoints[i];
        }
        if(windowSize==0){
            return sum;
        }
        for(int i =0;i<cardPoints.length;i++){
            curSum+=cardPoints[i];
            if(i<windowSize-1){
                continue;
            }
            minSum = Math.min(minSum,curSum);
            curSum-= cardPoints[i-windowSize+1];
        }
        return sum-minSum;
    }

    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,1};
        System.out.println(new Solution().maxScore(a,3));
    }
}