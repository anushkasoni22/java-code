import java.util.Arrays;

class Day68{
    //K-th element of two Arrays
    public int kthElement(int a[], int b[], int k) {
        int arr[] = new int[a.length + b.length];
        int i=0, j=0, z=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                arr[z] = a[i];
                i++;
            }
            else{
                arr[z]=b[j];
                j++;
            }
            z++;
        }
        while(i<a.length){
            arr[z]=a[i];
            i++;
            z++;
        }
        while(j<b.length){
            arr[z]=b[j];
            j++;
            z++;
        }
        return arr[k-1];
    }

    //Final Array State After K Multiplication Operations I (leetcode)
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for(int i=0; i<k; i++){
            int minval = 0;
            for(int j=0; j<n; j++){
                if(nums[j] < nums[minval]){
                    minval = j;
                }
            }

            nums[minval] *= multiplier;
        }
        return nums;
    }

    public static void main (String arge[]){
        Day68 d = new Day68();
        int a[] = {2,3,6,7,9} , b[] = {1,4,8,10}, k = 5;
        System.out.println(d.kthElement(a, b, k));

        int nums[] = {2,1,3,5,6}, m = 5, multiplier = 2;
        System.out.println(Arrays.toString(d.getFinalState(nums, k, multiplier)));
    }
}