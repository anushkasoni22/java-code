import java.util.Arrays;

class Day40{
    //Defuse the bomb(leetcode)
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k == 0){
            for(int i =0; i<n; i++){
                res[i] = 0;
            }
        }
        else if(k>0){
            for(int i=0; i<n; i++){
                for(int j=1; j<=k; j++){
                    res[i] = res[i] + code[(i+j)%n];
                }
            }
        }
        else{
            for(int i=0; i<n; i++){
                for(int j=-1; j>=k; j--){
                    int index = (i+j)%n;
                    if(index<0){
                        index = n+index;
                    }
                    res[i] = res[i] + code[index];
                }
            }
        }
        return res;
    }
    
        //rotate array
        static void rotateArr(int arr[], int d) {
            int n = arr.length;
            d = d%n;
            rev(arr,0,d-1);
            rev(arr,d,n-1);
            rev(arr,0,n-1);
              
          }
        static void rev(int arr[], int i, int j){
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    
        public static void main(String[] args) {
            int[] code = {5,7,1,4};
            int k = 3;
            System.out.println(Arrays.toString(decrypt(code, k)));

        int arr[] = {1, 2, 3, 4, 5};
        int d = 2;
        rotateArr(arr, d);
        System.out.println(Arrays.toString(arr));
    }   
}