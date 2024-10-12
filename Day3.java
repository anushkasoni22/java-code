public class Day3 {
    public static int PairWithMaxSum(int arr[]){
        if(arr.length <= 1){
            return -1;
        }
        
        int sum = arr[0] + arr[1];
        for(int i=1; i<arr.length-1; i++){
            sum = Math.max(sum, arr[i] + arr[i+1]);
        }
        return sum;
    }
    
    public static void main(String args[]){
        int arr[] = {4,3,1,5,6};
        System.out.println(PairWithMaxSum(arr));
    }
}
