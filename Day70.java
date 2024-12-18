public class Day70 {
    //Allocate Minimum Pages
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        
        if(k>n){
            return -1;
        }
        
        int sum = 0;
        for(int num: arr){
            sum += num;
        }
        
        int  low = 0, high = sum;
        int ans = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(isValid(arr, k, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    private static boolean isValid(int[] arr, int k, int maxPages){
        int stu = 1, pages = 0;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>maxPages){
                return false;
            }
            
            if(pages + arr[i]<=maxPages){
                pages += arr[i];
            }
            else{
                stu++;
                pages = arr[i];
            }
        }
        return stu > k ? false : true;
    }

    //Final Prices With a Special Discount in a Shop
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = new int[n];

        for(int i=0; i<n; i++){
            ans[i] = prices[i];
            for(int j =i+1; j<n; j++){
                if(prices[j] <= prices[i]){
                    ans[i] -= prices[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day70 d = new Day70();
        int arr[] = {12, 34, 67, 90};
        int k = 2; 
        System.out.println(findPages(arr, k));

        int prices[] = {8,4,6,2,3};
        int[] result = d.finalPrices(prices);
        System.out.println("Final Prices with Discount:");
        for (int price : result) {
            System.out.print(price + " ");
        }    
    }
}
