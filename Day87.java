class Day87{
    //Count all triplets with given sum in sorted array
    public int countTriplets(int[] arr, int target) {
        int n = arr.length; 
        int count = 0; 

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;    
            int right = n - 1;   

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    if (arr[left] == arr[right]) {
                        int length = right - left + 1;
                        count += (length * (length - 1)) / 2; 
                        break; 
                    }
                    
                    int leftCount = 1; 
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++; 
                        leftCount++;
                    }
    
                    int rightCount = 1; 
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--; 
                        rightCount++;
                    }

                    count += leftCount * rightCount;
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Day87 day87 = new Day87();
        int arr[] = {-3,-1,-1,0,1,2}, target = -2;
        System.out.println(day87.countTriplets(arr, target));
    }
}