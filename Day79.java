import java.util.HashMap;

class Day79{
    //Count pairs with given sum(gfg)
    int countPairs(int arr[], int target) {
        int ans=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i:arr){
            if(mp.get(target-i)!=null){
                ans+=mp.get(target-i);
            }    
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        return ans;
    }

    //Best Sightseeing Pair(leetcode)
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int result = 0;
        int max = values[0] + 0; 

        for (int j = 1; j < n; j++) {
            int x = values[j] - j;
            int y = max;

            result = Math.max(result, x + y);
            max = Math.max(max, values[j] + j);
        }
        return result;
    }

    public static void main(String[] args) {
        Day79 obj = new Day79();
        int arr[] = {1, 5, 7, -1, 5}, target = 6;
        System.out.println(obj.countPairs(arr, target));

        int values[] = {8,1,5,2,6};
        System.out.println(obj.maxScoreSightseeingPair(values));
    }
}