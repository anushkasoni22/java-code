import java.util.ArrayList;

class Day61{
    //Special Array (leetcode)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] p = new int[nums.length];
        p[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                p[i] = p[i - 1] + 1;
            } else {
                p[i] = p[i - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            
            ans[i] = p[end] - p[start] == 0;
        }
        return ans;
    }

    //Insert Interval (gfg)
    public static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        boolean merged=false;
        int start=newInterval[0],end=newInterval[1];
        for(int x[]:intervals){
            if(x[1]<newInterval[0])ans.add(x);
            else if(x[0]>newInterval[1]){
                if(!merged){
                    int temp[] = new int[2];
                    temp[0]=start;
                    temp[1]=end;
                    ans.add(temp);
                    merged=true;
                }
                ans.add(x);
            }
            else{
                start=Math.min(x[0],start);
                end=Math.max(x[1],end);
            }
        }
        if(!merged){
            int temp[] = new int[2];
            temp[0]=start;
            temp[1]=end;
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String args[]){
        Day61 d = new Day61();
        int nums[] = {3,4,1,2,6};
        int queries[][] = {{0,4}};
        boolean[] res = d.isArraySpecial(nums, queries);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i] + " ");
        }
        System.err.println();

        int intervals[][] = {{1,3}, {4,5}, {6,7}, {8,10}};
        int newInterval[] = {5,6};
        ArrayList<int[]> res1 = insertInterval(intervals, newInterval);
        for(int i=0; i<res1.size(); i++){
            System.out.print("{" + res1.get(i)[0] + "," + res1.get(i)[1] + "} "); 
        }
    }
}