class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;

        int minutes = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();
            minutes++;

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();

                for(int[] dir : directions){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                       grid[r][c] = 2;
                       queue.offer(new int[]{r, c});
                       freshOranges--; 
                    }
                }
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
