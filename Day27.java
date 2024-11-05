public class Day27 {
    //Rotate by 90 degree
    static void rotate(int mat[][]) {
        // Code Here
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - 1 - j];
                mat[i][mat.length - 1 - j] = temp;
            }
        }    
    }

    //Minimum Number of Changes to Make Binary String Beautiful
    public static int minChanges(String s) {
            int count = 0;
            int i = 0;
    
            while(i<s.length()){
                if(s.charAt(i)!=s.charAt(i+1)){
                    count++;
                }
    
                i += 2;
            }
            return count;
        }
    
        public static void main(String[] args) {
            int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
            rotate(mat);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
    
            System.out.println("Minimum Number of Changes to Make Binary String Beautiful");
            System.out.println(minChanges("1001"));
    }
}
