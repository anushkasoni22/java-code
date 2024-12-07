import java.util.Arrays;

class Day59{
    //Count Inversions
    private int ans = 0;

    private void merge(int[] arr, int low, int high, int mid) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) arr1[i] = arr[low + i];
        for (int i = 0; i < n2; i++) arr2[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
                ans += (n1 - i); 
            }
        }

        while (i < n1) arr[k++] = arr1[i++];
        while (j < n2) arr[k++] = arr2[j++];
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    public int inversionCount(int[] arr) {
        ans = 0; 
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    public boolean isPossible(int[] nums, int maxOps, int mid) {
        int totalOps = 0; 

        for (int num : nums) {
            int ops = num / mid;

            if (num % mid == 0) {
                ops -= 1;
            }
            totalOps += ops;
        }
        return totalOps <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();     
        int result = r; 

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Day59 d = new Day59();
        int arr[] = {2,4,1,3,5};
        System.out.println(d.inversionCount(arr)); // Output: 3
        
        int[] nums = {2,4,8,2}; 
        int maxOperations = 4;
        System.out.println(d.minimumSize(nums, maxOperations)); // Output: 2
    }
}