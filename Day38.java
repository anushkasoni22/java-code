class Day38{
    //Move All Zeroes to End (gfg)
    public void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int j=0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
    
    //Find the Power of K-Size Subarrays I (leetcode)
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
    
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    results[i] = -1; 
                    break;
                }
                max = Math.max(max, nums[j + 1]);
            }
            if (results[i] != -1) {
                results[i] = max;
            }
        }
    
        return results;
    }
    
    public static void main(String[] args) {
        Day38 d = new Day38();
        int arr[] = {1,2,0,4,3,0,5,0};
        d.pushZerosToEnd(arr);
        for(int i=0; i<arr.length; i++){
           System.out.print(arr[i] + " ");
        }

       int nums[] = {1,2,3,4,3,2,5};
       int k = 3;
       int[] res = d.resultsArray(nums, k);
       for(int i=0; i<res.length; i++){
           System.out.print(res[i] + " ");
       }
   }
}