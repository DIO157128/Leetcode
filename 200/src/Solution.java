class Solution {
    boolean inArea(char [][]grid,int r,int c){
        return (r>=0&&r< grid.length)&&(c>=0&&c<grid[0].length);
    }
    void dfs(char [][]grid,int r, int c){
        if(!inArea(grid, r, c)){
            return;
        }
        if(grid[r][c]!='1'){
            return;
        }
        grid[r][c] = '2';
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r-1, c);
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i< grid.length;i++){
            for(int j =0;j< grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','0'},{'1','0'}};
        System.out.println(new Solution().numIslands(grid));
    }
}