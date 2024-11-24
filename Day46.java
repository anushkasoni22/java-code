class Day46{
    //Kadane's Algorithm(gfg)
    int maxSubarraySum(int[] arr) {
        int maxsum = Integer.MIN_VALUE;
        int cursum = 0;
        for(int i=0; i<arr.length; i++){
            cursum = cursum + arr[i];
            if(cursum > maxsum){
                maxsum = cursum;
            }
            if(cursum < 0){
                cursum = 0;
            }
        }
        return maxsum;
    }

    //Maximum Matrix Sum(leetcode)
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long sum = 0;
        int negcount = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);

                if (matrix[i][j] < 0) {
                    negcount++;
                }
                mini = Math.min(mini, Math.abs(matrix[i][j]));
            }
        }
        if (negcount % 2 == 0) {
            return sum;
        }
        return sum - 2L * mini;
    }

    public static void main(String[] args) {
        Day46 obj = new Day46();
        int arr[] = {2,3,-8,7,-1,2,3};
        System.out.println(obj.maxSubarraySum(arr));// Output: 11

        int matrix[][] = {{1,-1},{-1,1}};
        System.out.println(obj.maxMatrixSum(matrix));// Output: 4
    }
}