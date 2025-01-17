public class Day100 {
    //Product array puzzle (gfg)
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int temp = 1, count = 0, zero = -1;
        int res[] = new int[n];
        
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                temp *= arr[i];
            }
            else{
                count++;
                zero = i;
            }
        }
        if(count > 1){
            return res;
        }
        if(count == 1){
            res[zero] = temp;
            return res;
        }
        for(int i=0; i<n; i++){
            res[i] = temp/arr[i];
        }
        return res;
    }

    public static void main (String args[]){
        int arr[] = {10, 3, 5, 6, 2};
        int result[] = productExceptSelf(arr);
        System.out.println("Product of all numbers except self is");
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }   
    }
}
