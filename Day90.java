import java.util.ArrayList;
import java.util.List;

class Day90{
    // String Matching in an Array (leetcode)
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

    //Pair with given sum in a sorted array
    public int countPairs(int arr[], int target) {
        int n = arr.length;
        int i = 0, j = n-1;
        int count = 0;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                if(arr[i] == arr[j]){
                    int len = j-i+1;
                    count += (len*(len-1))/2;
                    break;
                }
                
                int left = 1;
                while(i<j && arr[i] == arr[i+1]){
                    left++;
                    i++;
                }
                
                int right = 1;
                while(i<j && arr[j] == arr[j-1]){
                    right++;
                    j--;
                }
                count += left*right;
                i++;
                j--;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        Day90 d = new Day90();
        String words[] = {"mass","as","hero","superhero"};
        List<String> ans = d.stringMatching(words);
        System.out.println(ans);

        int arr[] = {-1,1,5,5,7}, target=6;
        System.out.println(d.countPairs(arr, target));
    }
}