public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                liveOrDie(board, i, j, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        
        return;
    }
    
    void liveOrDie(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (i-1 >= 0 && j-1 >= 0 && ((board[i-1][j-1]) & 1) == 1) count++;
        if (i-1 >= 0 && ((board[i-1][j]) & 1) == 1) count++;
        if (i-1 >= 0 && j+1 < n && ((board[i-1][j+1]) & 1) == 1) count++;
        if (j-1 >= 0 && ((board[i][j-1]) & 1) == 1) count++;
        if (j+1 < n && ((board[i][j+1]) & 1) == 1) count++;
        if (i+1 < m && j-1 >= 0 && ((board[i+1][j-1]) & 1) == 1) count++;
        if (i+1 < m && ((board[i+1][j]) & 1) == 1) count++;
        if (i+1 < m && j+1 < n && ((board[i+1][j+1]) & 1) == 1) count++;
        
        System.out.println(count);
        
        if (board[i][j] == 1) {
            if (count == 2 || count == 3)   board[i][j] |= 2;
        } else {
            if (count == 3) board[i][j] |= 2;
        }
        
        return;
    }
}