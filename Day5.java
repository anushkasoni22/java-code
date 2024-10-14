public class Day5 {
    long maxSubarraySum(int[] arr) {
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
    public static void main(String args[]){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        Day5 d = new Day5();
        System.out.println(d.maxSubarraySum(arr));
    }
}
