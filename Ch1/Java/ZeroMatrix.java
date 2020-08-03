import java.util.HashSet;
import java.util.Arrays;
public class ZeroMatrix {

    public static void main(String[] args) {
        int numRows = (int) (Math.random()*10) + 1;
        int numCols = (int) (Math.random()*10) + 1;
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = (int) (Math.random()*10);
            }
        }

        print2DArray(matrix);
        zeroMatrix(matrix);
        print2DArray(matrix);
    }

    public static void print2DArray(int[][] arr) {
        System.out.printf("%s\n\n", Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    public static void zeroMatrix(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rowSet.add(row);
                    colSet.add(col);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (rowSet.contains(row) || colSet.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }



}