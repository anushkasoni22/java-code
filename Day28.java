public class Day28 {
    public boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE;
        int currMax = nums[0];
        int currMin = nums[0];
        int set_bitC = Integer.bitCount(nums[0]);
        int i = 1;
        while(i < nums.length){
            while(i < nums.length && Integer.bitCount(nums[i]) == set_bitC){
                currMax = Math.max(currMax, nums[i]);
                currMin = Math.min(currMin, nums[i]);
                i++;
            }

            if(prevMax > currMin){
                return false;
            } else if(i < nums.length){
                prevMax = currMax;
                currMax = nums[i];
                currMin = nums[i];
                set_bitC = Integer.bitCount(nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day28 d = new Day28();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(d.canSortArray(nums));
    }   
}
