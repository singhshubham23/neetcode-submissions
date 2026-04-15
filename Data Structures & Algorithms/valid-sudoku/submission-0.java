class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char number = board[i][j];
                if(number != '.'){
                    String rKey = number + "in row" + i;
                    String cKey = number + "in col" + j;
                    String bKey = number + "in box" + (i/3) + "-" + (j/3);

                    if(!seen.add(rKey)||
                       !seen.add(cKey)||
                       !seen.add(bKey)
                       ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
