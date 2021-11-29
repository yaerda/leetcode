//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 5542 👎 746


package leetcode.editor.en;

import tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Tool.print(solution.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>();
            }
            int row = matrix.length, col = matrix[0].length;
            int startRow = 0, endRow = row - 1, startCol = 0, endCol = col - 1;
            List<Integer> list = new ArrayList<>();
            int dir = 0;
            while (startRow <= endRow && startCol <= endCol) {
                switch (dir) {
                    case 0:
                        for (int j = startCol; j <= endCol; j++) {
                            list.add(matrix[startRow][j]);
                        }
                        startRow++;
                        break;
                    case 1:
                        for (int j = startRow; j <= endRow; j++) {
                            list.add(matrix[j][endCol]);
                        }
                        endCol--;
                        break;
                    case 2:
                        for (int j = endCol; j >= startCol; j--) {
                            list.add(matrix[endRow][j]);
                        }
                        endRow--;
                        break;
                    case 3:
                        for (int j = endRow; j >= startRow; j--) {
                            list.add(matrix[j][startCol]);
                        }
                        startCol++;
                        break;
                }
                dir = (++dir) % 4; // 通过switch 的分支控制，可以在每一行、列 结束后，重新判断while内的总条件是否满足；
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
