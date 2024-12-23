class Day75{
    //Search in a row-wise sorted matrix(gfg)
    public boolean searchRow(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            if (arr[mid] == x) return true;
            else if (arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (mat[i][0] <= x && x <= mat[i][m - 1]) {
                if (searchRow(mat[i], x)) return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Day75 d = new Day75();  
        int mat[][] = {{3,4,9}, {2,5,6}, {9,25,27}};
        int x = 9;
        System.out.println(d.searchRowMatrix(mat, x));
    }
}