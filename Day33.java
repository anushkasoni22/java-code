import java.util.Arrays;

public class Day33 {
    //Prime Subraction Operation (leetcode)
    /*You are given a 0-indexed integer array nums of length n.
    You can perform the following operation as many times as you want:
    Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
    Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
    A strictly increasing array is an array whose each element is strictly greater than its preceding element. */

    private boolean[] isPrime = new boolean[1000 + 1];

    private void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false; 
        isPrime[1] = false; 

        int m = 1000;
        for (int i = 2; i * i <= m; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        sieve();

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) continue;

            for (int p = 2; p < nums[i]; p++) {
                if (!isPrime[p]) continue;

                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }

            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Make array elements unique (gfg)
    /*Given an array arr[ ], your task is to find the minimum number of increment operations required to make all the elements of the array unique. 
    i.e.- no value in the array should occur more than once. In one operation, a value can be incremented by 1 only. */
    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int count = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] <= arr[i-1]){
                int increament = arr[i-1] + 1 - arr[i];
                arr[i] += increament;
                count += increament;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Day33 d = new Day33();
        int[] arr = {1,2,3,1};
        System.out.println(d.minIncrements(arr));

        int nums[] = {4,9,6,10};
        System.out.println(d.primeSubOperation(nums));
    }
}
