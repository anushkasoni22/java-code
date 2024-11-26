public class Day48 {
    //Max Circular Subarray Sum{gfg}
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE, minsum = Integer.MAX_VALUE;
        int curmin = 0, curmax=0, totalsum = 0;
        
        for(int num : arr){
            totalsum += num;
            
            curmax = Math.max(num, curmax + num);
            maxsum = Math.max(curmax, maxsum);
            
            curmin = Math.min(num, curmin+num);
            minsum = Math.min(curmin, minsum);
        }
        
        if(maxsum < 0){
            return maxsum;
        }
        return Math.max(maxsum, totalsum - minsum);
    }

    //Find Champion II(leetcode)
    public int findChampion(int n, int[][] edges) {
        int[] deg = new int[n];  
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            deg[v]++;
        }

        int champ = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                champ = i; 
                count++;
                if (count > 1) {
                    return -1; 
                }
            }
        }
        return champ;
    }

    public static void main(String[] args) {
        Day48 obj = new Day48();
        int arr[] = {8, -8, 9, -9, 10, -11, 12};
        System.out.println("Max Circular Subarray Sum: " + obj.circularSubarraySum(arr));

        int edges[][] = {{0,1},{1,2}};
        int n = 3;
        System.out.println("Champion: " + obj.findChampion(n, edges));
    }
}
