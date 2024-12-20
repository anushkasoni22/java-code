import java.util.ArrayList;

public class Day72 {
    //Spirally traversing a matrix
    public static ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = mat.length;        
        if (n == 0) return result; 
        int m = mat[0].length;     
        
        int startRow = 0, endRow = n - 1, startCol = 0, endCol = m - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(mat[startRow][j]);
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                result.add(mat[i][endCol]);
            }
            endCol--;

            if (startRow <= endRow) { 
                for (int j = endCol; j >= startCol; j--) {
                    result.add(mat[endRow][j]);
                }
                endRow--;
            }

            if (startCol <= endCol) { 
                for (int i = endRow; i >= startRow; i--) {
                    result.add(mat[i][startCol]);
                }
                startCol++;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        int mat[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
        ArrayList<Integer> result = spirallyTraverse(mat);   
        System.out.println(result);
    }
}
