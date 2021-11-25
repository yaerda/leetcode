//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
//idated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
//epetition. 
// 
//
// 
//A partially filled sudoku which is valid. 
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'. 
//
// Example 1: 
//
// 
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// 
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// The given board contain only digits 1-9 and the character '.'. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table 
// 👍 1810 👎 468


package leetcode.editor.en;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        char[][] board = new char[][]
                {
                        {
                                '5', '3', '.', '.', '7', '.', '.', '.', '.'
                        },
                        {
                                '6', '.', '.', '1', '9', '5', '.', '.', '.'
                        },
                        {
                                '.', '9', '8', '.', '.', '.', '.', '6', '.'
                        },
                        {
                                '8', '.', '.', '.', '6', '.', '.', '.', '3'
                        },
                        {
                                '4', '.', '.', '8', '.', '3', '.', '.', '1'
                        },
                        {
                                '7', '.', '.', '.', '2', '.', '.', '.', '6'
                        },
                        {
                                '.', '6', '.', '.', '.', '.', '2', '8', '.'
                        },
                        {
                                '.', '.', '.', '4', '1', '9', '.', '.', '5'
                        },
                        {
                                '.', '.', '.', '.', '8', '.', '.', '7', '9'
                        }
                };
        boolean result = solution.isValidSudoku(board);
        System.out.print("result is : " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            printBoard(board);
            //check row
            char[][] boardColumn = new char[9][9];
            char[][] subBoard = new char[9][9];
            for (int i = 0; i < board.length; i++) {
                if (!check(board[i])) return false;
                for (int j = 0; j < 9; j++) {
                    int subi = (i / 3) * 3 + (j / 3);
                    int subj = (i % 3) * 3 + (j % 3);
                    boardColumn[j][i] = board[i][j];
                    subBoard[subi][subj] = board[i][j];
                }
            }
            printBoard(boardColumn);
            printBoard(subBoard);
            //check column
            for (int i = 0; i < boardColumn.length; i++) {
                if (!check(boardColumn[i])) return false;
            }
            //check sub-board
            for (int i = 0; i < subBoard.length; i++) {
                if (!check(subBoard[i])) return false;
            }
            return true;
        }

        private void printBoard(char[][] board) {
            System.out.println();
            for (int i = 0; i < 9; i++) {
                System.out.println();
                if (i % 3 == 0) {
                    for (int m = 0; m < 37; m++) {
                        System.out.print(i == 0 ? "_" : '-');
                    }
                    System.out.println();
                }
                for (int j = 0; j < 9; j++) {
                    if (j % 3 == 0) {
                        System.out.print("|");
                    }
                    System.out.print(board[i][j]);
                    System.out.print(' ');
                    System.out.print(' ');
                    System.out.print(' ');
                    if (j == 8) {
                        System.out.print("|");
                    }
                }
            }
            System.out.println();
        }

        private boolean check(char[] nums) {
            int[] poss = new int[9];
            for (int i = 0; i < nums.length; i++) {
                char posCha = nums[i];
                if (posCha != '.') {
                    int pos = posCha - '0';
                    if (pos < 1 || pos > 9) {
                        return false;
                    } else if (poss[pos - 1] != 0) {
                        return false;
                    } else {
                        poss[pos - 1] = pos;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}