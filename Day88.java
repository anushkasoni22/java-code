import java.util.Arrays;

class Day88{
    //Count Pairs whose sum is less than target

    public int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0, right = arr.length-1;
        int count = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum < target){
                count += (right - left);
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Day88 day = new Day88();
        int arr[] = {7,2,5,3}, target = 8;
        System.out.println(day.countPairs(arr, target));
    }
}