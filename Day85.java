import java.util.Arrays;
import java.util.HashMap;

class Day85{
    //Count Vowel Strings in Ranges (leetcode)
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
       int m = words.length; 
       int n = queries.length;
       int ans[] = new int[n];
       int cumsum[] = new int[m];

       int sum = 0;
       for(int i=0; i<m; i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
            sum++;
            }
        cumsum[i] = sum;
        }

        for(int i=0; i<n; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = cumsum[r] - (l>0 ? cumsum[l-1] : 0);
        }
        return ans;
    }

    //Subarrays with sum K (gfg)
    public int countSubarrays(int arr[], int k) {
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i : arr){
            sum += i;
            
            if(sum == k){
                ans++;
            }
            ans += mp.getOrDefault(sum-k, 0);
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Day85 obj = new Day85();
        String words[] = {"aba","bcb","ece","aa","e"};
        int queries[][] = {{0,2},{1,1},{1,4}}; 
        int ans[] = obj.vowelStrings(words, queries);
        System.out.println(Arrays.toString(ans));

        int arr[] = {10,2,-2,-20,10}, k = -10;
        System.out.println(obj.countSubarrays(arr, k));
    }
}