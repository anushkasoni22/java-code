class Day67{
    //peak element (gfg)
    public int peakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; 
            } else {
                right = mid;
            }
        }
        return left;
    } 

    public static void main(String[] args) {
        Day67 obj = new Day67();
        int arr[] = {1,2,4,5,7,8,3};
        System.out.println("Peak element is at index " + obj.peakElement(arr));
    }
}