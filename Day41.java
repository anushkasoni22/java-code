import java.util.HashSet;
import java.util.Set;

class Day41{
    //Maximum Sum of Distinct Subarrays With Length K(leetcode)
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;
        
        for (int end = 0; end < n; end++) {
            if (!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);
                
                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        
        return maxSum;
    }

    //Next Permutation
    static void rev(int arr[], int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    void nextPermutation(int[] arr) {
       int n = arr.length, index = -1;
       for(int i=n-1; i>=1; i--){
           if(arr[i-1]<arr[i]){
               index=i-1;
               break;
           }
       }
       if(index == -1){
           rev(arr, 0, n-1);
           return;
       }
       for(int i=n-1; i>index; i--){
           if(arr[i] > arr[index]){
               int temp = arr[i];
               arr[i] = arr[index];
               arr[index] = temp;
               break;
           }
       }
       rev(arr, index+1, n-1);
    }

    public static void main(String[] args) {
        Day41 d = new Day41();
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(d.maximumSubarraySum(nums, k));

        int arr[] = {2,4,1,7,5,0};
        d.nextPermutation(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }      
}