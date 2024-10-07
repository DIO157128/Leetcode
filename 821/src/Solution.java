import java.util.ArrayList;

class Solution {
    int curLabel;
    ArrayList<Integer> areas;
    ArrayList<Integer> curLabels;
    public boolean inArea(int[][] grid, int r,int c){
        return r>= 0&&r<grid.length&&c>=0&&c<grid[0].length;
    }
    public int dfsLand(int[][] grid, int r,int c){
        if(!inArea(grid, r, c)){
            return 0;
        }
        if(grid[r][c]!=1){
            return 0;
        }
        grid[r][c] = this.curLabel;
        return 1+dfsLand(grid, r+1, c)+dfsLand(grid, r-1, c)+dfsLand(grid, r, c+1)+dfsLand(grid, r, c-1);
    }
    public int nearArea(int[][] grid, int r,int c){
        if (!inArea(grid, r, c)){
            return 0;
        }
        int curlabel = grid[r][c]-2;
        if(curlabel<0||curLabels.contains(curlabel)){
            return 0;
        }
        curLabels.add(curlabel);
        return areas.get(curlabel);
    }
    public int largestIsland(int[][] grid) {
        this.areas = new ArrayList<>();
        this.curLabel =1;
        for(int i =0;i< grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    curLabel++;
                    int area = dfsLand(grid,i,j);
                    areas.add(area);
                }
            }
        }
        int areaAfter = 0;
        int count = 0;
        for(int i =0;i< grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    count++;
                    curLabels = new ArrayList<>();
                    areaAfter = Math.max(areaAfter,1+nearArea(grid,i-1,j)+nearArea(grid,i+1,j)+nearArea(grid,i,j-1)+nearArea(grid,i,j+1));
                }
            }
        }
        if (count==0){
            return grid.length* grid[0].length;
        }
        return areaAfter;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1},{0,1}};
        System.out.println(new Solution().largestIsland(grid));
    }
}