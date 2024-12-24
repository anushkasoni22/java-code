class Day76{
    //Search in a sorted Matrix(gfg)
    public static boolean searchMatrix(int[][] mat, int x) {
        int row = 0, col = mat[0].length-1;
        while(row < mat.length && col >= 0){
            if(mat[row][col] == x){
                return true;
            }
            else if(mat[row][col] > x){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {{3,30,38},{20,52,54},{35,60,69}}; 
        int x = 62;
        System.out.println(searchMatrix(mat, x));   
    }
}