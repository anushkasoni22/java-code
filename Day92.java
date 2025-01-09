import java.util.ArrayList;

class Day92{
    //Counting Words With a Given Prefix (leetcode)
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for(String i : words){
            if(i.startsWith(pref)){
                count++;
            }
        }
        return count;
    }

    //Indexes of subarray sum(gfg)
    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n=arr.length,j=0,sum=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>target && j<i){
                sum-=arr[j++];
            }
            
            if(sum==target){
                ans.add(j+1);
                ans.add(i+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        Day92 obj = new Day92();
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(obj.prefixCount(words, pref));

        int arr[] = {1,2,3,7,5}, target = 12;
        System.out.println(obj.subarraySum(arr, target));
    }
}