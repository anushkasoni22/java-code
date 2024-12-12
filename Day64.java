import java.util.Collections;
import java.util.PriorityQueue;

public class Day64 {
    //Take Gifts From the Richest Pile(leetcode)
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int g: gifts) pq.add(g);
        for(int i=0; i<k; i++) {
            pq.add((int)Math.floor(Math.sqrt(pq.remove())));
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum+=pq.remove();
        }
        return sum;
    }

    //Number of occurrence (gfg)
    public static int countFreq(int[] arr, int target) {
        int n=arr.length,l=0,mid=0,r=n-1,fIdx=-1,lIdx=-1;
        for(int i=0;i<2;i++){
            l=0;
            r=n-1;
            while(l<=r){
                mid=(l+r)/2;
                if(arr[mid]==target){
                    if(i==0){
                        fIdx=mid;
                        r=mid-1;
                    }
                    else{
                        lIdx=mid;
                        l=mid+1;
                    }
                }
                else if(arr[mid]>target)r=mid-1;
                else l=mid+1;
            }
        }
        if(fIdx==-1)return 0;
        return lIdx-fIdx+1;
    }

    public static void main(String[] args) {
        Day64 obj = new Day64();
        System.out.println(obj.pickGifts(new int[]{25, 64, 9, 4, 100}, 4));

        int arr[] = {1,1,2,2,2,2,3};
        int target = 2;
        System.out.println(countFreq(arr, target));
    }
}
