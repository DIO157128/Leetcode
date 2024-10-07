import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []inDegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i< inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            ArrayList<Integer> nextCourses = map.getOrDefault(course,new ArrayList<>());
            for(int nextCourse : nextCourses){
                if(--inDegree[nextCourse]==0){
                    queue.add(nextCourse);
                }
            }
        }
        return numCourses==0;
    }
}