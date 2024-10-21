class Day12{
    /*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums. */
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=1; i<nums.length; i++){
         if(nums[i] != nums[i-1]){
             nums[j] = nums[i];
             j++;
         }
        } 
        return j;
     }

    public static void main(String[] args) {
        Day12 d = new Day12();
        int[] arr = {0,0,1,1,1,1,2,3,4,4};
        System.out.println(d.removeDuplicates(arr));
    }
}