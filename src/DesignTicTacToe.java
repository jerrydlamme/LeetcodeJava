
public class DesignTicTacToe {

    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int full;
    
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
        full = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            if (++rows[row] == full) return 1;
            if (++cols[col] == full) return 1;
            if (row == col) {
                if(++diag == full) return 1;
            }
            if (row + col == full - 1) {
                if(++antiDiag == full) return 1; 
            }
        } else {
            if (--rows[row] == 0 - full) return 2;
            if (--cols[col] == 0 - full) return 2;
            if (row == col) {
                if(--diag == 0 - full) return 2;
            }
            if (row + col == full - 1) {
                if(--antiDiag == 0 - full) return 2; 
            }
        }
        
        return 0;
    }
}
