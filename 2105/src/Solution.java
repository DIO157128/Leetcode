class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length-1;
        int ans = 0;
        int curCapaA = capacityA;
        int curCapaB = capacityB;
        while(left<=right){
            if(left == right){
                if(Math.max(curCapaA,curCapaB)<plants[left]){
                    ans+=1;
                }
                break;
            }
            else{
                if(curCapaA>=plants[left]){
                    curCapaA-=plants[left];
                }
                else{
                    ans+=1;
                    curCapaA = capacityA-plants[left];
                }
                left++;
                if(curCapaB>=plants[right]){
                    curCapaB-=plants[right];
                }
                else{
                    ans+=1;
                    curCapaB = capacityB-plants[right];
                }
                right--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[]plants = {1,2,4,4,5};
        System.out.println(new Solution().minimumRefill(plants,6,5));
    }
}