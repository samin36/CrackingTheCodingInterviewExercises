import java.util.Arrays;
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[8][8];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random()*10) + 1;
            }
        }
        print2DArray(matrix);
        rotateMatrix(matrix);
        print2DArray(matrix);
    }
    
    public static void print2DArray(int[][] arr) {
        System.out.printf("%s\n\n", Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    public static void rotateMatrix(int[][] matrix) {
        //rotate's matrix clockwise 90 degrees in-place
        int[][] newIndexes = new int[matrix.length * matrix.length][1];
        int index = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                // System.out.printf("(%d, %d): %d\n", row, col, matrix[row][col]);
                int newRow = col;
                int newCol = matrix.length - row - 1;
                newIndexes[index] = new int[]{newRow, newCol, matrix[row][col]};
                index++;
            }
        }
        for (int[] mapping : newIndexes) {
            int newRow = mapping[0], newCol = mapping[1], val = mapping[2];
            matrix[newRow][newCol] = val;
        }
    }
}