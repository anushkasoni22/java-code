class Day71{
    //Max Chunks To Make Sorted(leetcode)
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxTillNow = -1;

        int chunkCount = 0;
        for (int i = 0; i < n; i++) {
            maxTillNow = Math.max(maxTillNow, arr[i]);

            if (maxTillNow == i) {
                chunkCount++;
            }
        }
        return chunkCount;
    }

    //Kth Missing Positive Number in a Sorted Array(gfg)
    public int findKthPositive(int[] arr, int k) {
        int count = 0, i = 1, j = 0;
        while(count < k){
            if(j < arr.length && i == arr[j]){
                i++;
                j++;
            }
            else{
                i++;
                count++;
            }
        }
        return i-1;
    }

    public static void main(String[] args) {
        Day71 d = new Day71();
        int[] arr = {4, 3, 2, 1, 0};
        System.out.println(d.maxChunksToSorted(arr));

        int arr1[] = {2,3,4,7,11}, k=5;
        System.out.println(d.findKthPositive(arr1, k));
    }
}