// 130. Surrounded Regions
public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 2) return;
        int col = board[0].length;
        if (col <= 2) return;
        for (int i = 0; i < row; i++) {
            save(board, i, 0, row, col);
            save(board, i, col - 1, row, col);
        }
        for (int j = 0; j < col; j++) {
            save(board, 0, j, row, col);
            save(board, row - 1, j, row, col);
        }
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    public void save(char[][] board, int i, int j, int maxRow, int maxCol) {
        if (board[i][j] != 'O') return;
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            if (i + 1 < maxRow) save(board, i + 1, j, maxRow, maxCol);
            if (i - 1 >= 0) save(board, i - 1, j, maxRow, maxCol);
            if (j + 1 < maxCol) save(board, i, j + 1, maxRow, maxCol);
            if (j - 1 >= 0) save(board, i, j - 1, maxRow, maxCol);
        }
    }
}
