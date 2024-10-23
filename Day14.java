/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function. */

class Day14{
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i=0; i< n-1; i++){
            for(int j=0; j< n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Day14 d = new Day14();
        int[] nums = {2,0,2,1,1,0};
        d.sortColors(nums);
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}