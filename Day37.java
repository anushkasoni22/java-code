public class Day37 {
    //Second Largest(gfg)
    public int getSecondLargest(int[] arr) {
        // Code Here
        int first = -1;  
        int second = -1; 
        
        for (int num : arr) {
                   
            if (num > first) {
                second = first;  
                first = num;     
            } else if (num < first && num > second) {
                second = num;    
            }
        }    
        return second;
    }

    //Shortest Subarray to be Removed to Make Array Sorted(leetcode)
    public int findLengthOfShortestSubarray(int[] arr) {
     
        int left = 0, right = arr.length-1;
        while(right>0 && arr[right]>=arr[right-1])
        right--;
        int ans = right;
        while(left<right && (left==0 || arr[left]>=arr[left-1]))
        {
            while(right<arr.length && arr[left]>arr[right])
            {
                right++;
            }
            ans = Math.min(ans, right-left-1);
            left++;
        } 
        return ans;   
    }

    public static void main(String[] args) {
        Day37 day37 = new Day37();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(day37.getSecondLargest(arr));

        int[] arr1 = {1,2,3,10,4,2,3,5};
        System.out.println(day37.findLengthOfShortestSubarray(arr1));
    }
}
