class Day73{
    public static void rotateby90(int mat[][]) {
        int n = mat.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j -1] = temp;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        rotateby90(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}