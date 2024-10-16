import java.util.*;
public class Day7 {
    public boolean checkSorted(List<Integer> arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=i+1){
                int temp = arr.get(i);
                arr.set(i,arr.get(arr.get(i)-1));
                arr.set(temp-1,temp);
                i--;
                count++;
            }
            if(count>2)return false;
        }
        return count==2|count==0;
    }
    
    public static void main(String args[]){
        Day7 d = new Day7();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(d.checkSorted(arr));
    }
}
