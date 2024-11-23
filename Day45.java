import java.util.Arrays;

class Day45{
    //Minimize the Heights I (gfg)
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int max = 0;
        int min = 0;
        int largest = arr[n-1] - k;
        int smallest = arr[0] + k;
        for(int i=0; i<n-1; i++){
            min = Math.min(smallest, arr[i+1]-k);
            max = Math.max(largest, arr[i]+k);
            ans = Math.min(ans, max-min);
        }
        return ans;
    }

    //Minimize the Heights II (gfg 160)
    public int getMinDiff2(int[] arr, int k) {
        int n = arr.length;
        if(n==1)return 0;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0],min=0,max=0;
        for(int i=1;i<n;i++){
            if(arr[i]-k<0)continue;
            min = Math.min(arr[0]+k,arr[i]-k);
            max = Math.max(arr[n-1]-k,arr[i-1]+k);
            ans = Math.min(ans,max-min);
        }
        return ans;
    }

    //Rotating the Box(leetcode)
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(result[i]);
        }
        for (int j = 0; j < m; j++) {
            int spaceBottomRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    spaceBottomRow = i - 1;
                    continue;
                }

                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[spaceBottomRow][j] = '#';
                    spaceBottomRow--;
                }
            }
        }

        return result;
    }
    
    private void reverseRow(char[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        } 
    }  

    public static void main(String[] args) {
        Day45 d = new Day45();
        int arr[] = {1,5,8,10};
        int k = 2;
        System.out.println(d.getMinDiff(k, arr));
        System.out.println(d.getMinDiff2(arr, k));

        char box[][] = {{'#','.','#'}};
        System.out.println(Arrays.deepToString(d.rotateTheBox(box)));
    }   
}