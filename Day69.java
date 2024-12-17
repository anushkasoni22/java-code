import java.util.Arrays;

class Day69{
    //Construct String With Repeat Limit
    public String repeatLimitedString(String s, int repeatLimit) {
        int count[] = new int[26];

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int i = 25;
        while(i >= 0){
            if(count[i] == 0){
                i--;
                continue;
            }
            
            char ch = (char)('a' + i);
            int freq = Math.min(count[i], repeatLimit);

            for(int k=0; k < freq; k++){
                result.append(ch);
            }
            count[i] -= freq;

            if (count[i] > 0) {
                int j = i - 1;
                while (j >= 0 && count[j] == 0) {
                    j--;
                }

                if (j < 0) {
                    break; 
                }

                result.append((char) ('a' + j));
                count[j]--;
            }
        }
        return result.toString();
    }

    //Aggressive Cows
    static boolean isPossible(int stalls[],int k,int mid,int n){
        int c=1,prev=stalls[0];
        for(int i=1;i<n;i++){
            if(stalls[i]-prev>=mid){
                c++;
                prev=stalls[i];
            }
        }
        return c>=k;
    }
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length,low=0,high=stalls[n-1]-stalls[0],mid,ans=0;
        while(low<=high){
            mid=(low+high)/2;
            if(isPossible(stalls,k,mid,n)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Day69 d = new Day69();
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(d.repeatLimitedString(s, repeatLimit));

        int stalls[] = {1,2,4,8,9}, k = 3;
        System.out.println(d.aggressiveCows(stalls, k));
    }
}