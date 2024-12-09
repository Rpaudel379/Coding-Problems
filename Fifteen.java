import java.util.HashMap;
import java.util.HashSet;

public class Fifteen {
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        char[][] sudoku = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // System.out.println(s.isValid(sudoku));
        System.out.println(s.usingString(sudoku));
        // System.out.println(s.revise1(sudoku));
        // System.out.println(s.revise2(sudoku));
        // System.out.println(s.revise3UsingInt(sudoku));
        System.out.println(s.revise4UsingIntBucket(sudoku));

    }
}

class Sudoku {

    public boolean usingString(char[][] board) {
        HashSet<String> sets = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!sets.add(number + " r " + i) ||
                            !sets.add(number + " c " + j) ||
                            !sets.add(number + " grid " + i / 3 + "-" + j / 3)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board) {

        HashMap<Integer, HashSet<Character>> grids = new HashMap<Integer, HashSet<Character>>();

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();

            for (int j = 0; j < board[0].length; j++) {

                char x = board[i][j];
                char y = board[j][i];

                if (x != '.') {

                    if (!row.add(board[i][j])) {
                        System.out.println(i + " " + j);
                        return false;
                    }
                    // row.add(board[i][j]);

                    // grid
                    int key = i / 3 * 3 + j / 3;
                    if (!grids.containsKey(key)) {
                        HashSet<Character> n = new HashSet<Character>();
                        n.add(board[i][j]);
                        grids.put(key, n);
                    } else {
                        HashSet<Character> n = grids.get(key);
                        if (!n.add(board[i][j])) {
                            return false;
                        }
                    }

                }

                if (y != '.') {

                    if (!col.add(board[j][i])) {
                        return false;
                    }

                    // col.add(board[j][i]);

                }

            }

        }
        return true;
    }

    public boolean revise1(char[][] board) {
        char empty = '.';
        HashMap<Integer, HashSet<Character>> grid = new HashMap<>();

        for (int i = 0; i < board.length; i++) {

            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {

                char x = board[i][j];
                char y = board[j][i];

                if (x != empty) {
                    // System.out.println(x);
                    if (!row.add(x)) {
                        return false;
                    }
                }

                if (y != empty) {
                    if (!column.add(y)) {
                        // System.out.println(y);
                        return false;
                    }

                    int box = i / 3 * 3 + j / 3;

                    if (grid.containsKey(box)) {
                        HashSet<Character> n = grid.get(box);
                        if (!n.add(y)) {
                            return false;
                        }
                    } else {
                        HashSet<Character> n = new HashSet<>();
                        n.add(y);
                        grid.put(box, n);
                    }

                }

            }
        }

        return true;
    }

    public boolean revise2(char[][] board) {

        char empty = '.';

        for (int i = 0; i < board.length; i++) {

            HashSet<Character> row = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {

                char x = board[i][j];
                char y = board[j][i];

                if (x != empty) {
                    if (!row.add(x)) {
                        System.out.println("row rep");
                        return false;
                    }
                }

                if (y != empty) {
                    if (!cols.add(y)) {
                        System.out.println("col rep");
                        return false;
                    }
                }

            }
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                if (!checkBlock(board, i, j)) {
                    System.out.println("block rep");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBlock(char[][] board, int iIdx, int jIdx) {
        char empty = '.';
        HashSet<Character> grid = new HashSet<>();

        int row = iIdx + 3;
        int col = jIdx + 3;

        for (int i = iIdx; i < row; i++) {
            for (int j = jIdx; j < col; j++) {

                if (board[i][j] != empty) {
                    if (!grid.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean revise3UsingInt(char[][] board) {

        char empty = '.';

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != empty) {

                    if (!checkPosition(board, i, j)) {
                        return false;
                    }

                }

            }
        }

        return true;
    }

    private boolean checkPosition(char[][] board, int row, int column) {

        int cur = board[row][column];

        // column
        for (int j = column; j < board[0].length; j++) {
            if (j != column && board[row][j] == cur) {
                return false;
            }
        }

        // row
        for (int i = row; i < board.length; i++) {
            if (i != row && board[i][column] == cur) {
                return false;
            }
        }

        // grid
        int gridI = 3 * (row / 3);
        int gridJ = 3 * (column / 3);

        for (int i = gridI; i < gridI + 3; i++) {
            for (int j = gridJ; j < gridJ + 3; j++) {
                if (i != row && j != column && board[i][j] == cur) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean revise4UsingIntBucket(char[][] board) {

        char empty = '.';
        int[][] row = new int[board.length][board[0].length];
        int[][] col = new int[board.length][board[0].length];
        int[][][] grid = new int[3][3][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                char c = board[i][j];
                if (c != empty) {

                    int index = c - '0' - 1;
                    System.out.println(index);

                    row[i][index]++;
                    col[j][index]++;
                    grid[i / 3][j / 3][index]++;

                    if (row[i][index] > 1 || col[j][index] > 1 || grid[i / 3][j / 3][index] > 1) {
                        return false;
                    }

                }

            }
        }

        return true;
    }

}