import java.util.Arrays;

class Day91{
    //Count Prefix and Suffix Pairs I (leetcode)
    public boolean isPrefixAndASuffix(String s1, String s2){
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isPrefixAndASuffix(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    //Count the number of possible triangles(gfg)
    public static int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;       
        for(int k=n-1; k >= 2; k--){
            int i=0, j=k-1;
            
            while(i<j){
                if(arr[i] + arr[j] > arr[k]){
                    count += j-i;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        System.out.println(new Day91().countPrefixSuffixPairs(words));

        int arr[] = {4,6,3,7};
        System.out.println(countTriangles(arr));
    }
}