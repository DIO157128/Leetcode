import java.util.Stack;

public class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] after = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<temperatures.length;i++){
            int cur_temperature = temperatures[i];
            while(!stack.isEmpty()&&temperatures[stack.peek()]<cur_temperature){
                int index = stack.pop();
                after[index] = i-index;
            }
            stack.push(i);
        }
        return after;
    }

    public static void main(String[] args) {
        int[] temperature = {73,74,75,71,69,72,76,73};
        new Solution().dailyTemperatures(temperature);
    }
}
