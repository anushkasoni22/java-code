class Day66{
    //Continuous Subarrays
    public long continuousSubarrays(int[] nums) {
        int r = 0, l = 0;
        int mini, maxi;
        long ans = 0;

        mini = maxi = nums[0];

        for (r = 0; r < nums.length; r++) {
            mini = Math.min(mini, nums[r]);
            maxi = Math.max(maxi, nums[r]);

            if (maxi - mini > 2) {
                l = r;
                mini = maxi = nums[r];

                while (l > 0 && Math.abs(nums[r] - nums[l - 1]) <= 2) {
                    l--;
                    mini = Math.min(mini, nums[l]);
                    maxi = Math.max(maxi, nums[l]);
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }

    //Search in Rotated Sorted Array
    int search(int[] arr, int key) {
        int start = 0, end = arr.length-1;
        
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }
            else if(arr[start] <= arr[mid]){
                if(key >= arr[start] && key < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(key > arr[mid] && key <= arr[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Day66 d = new Day66();
        int nums[] = {5,4,2,4};
        System.out.println(d.continuousSubarrays(nums));

        int arr[] = {5,6,7,8,9,10,1,2,3,4};
        System.out.println(d.search(arr, 3));
    }
}