class Day22{
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = matrix[0][0], max = matrix[0][0];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] >  max){
                    max = matrix[i][j];
                }
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Day22 d = new Day22();
        System.out.println(d.searchMatrix(matrix, 3));
    }
}