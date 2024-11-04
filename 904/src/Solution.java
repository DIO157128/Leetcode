import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans  =0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int right=0;right<fruits.length;right++){
            int cur = fruits[right];
            sum+=1;
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }
            else{
                map.put(cur,1);
            }
            while(map.size()>2){
                if(map.containsKey(fruits[left])){
                    sum-=1;
                    map.put(fruits[left],map.get(fruits[left])-1);
                    if(map.get(fruits[left])==0){
                        map.remove(fruits[left]);
                    }
                }
                left++;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = {1,0,1,4,1,4,1,2,3};
        System.out.println(new Solution().totalFruit(res));
    }
}