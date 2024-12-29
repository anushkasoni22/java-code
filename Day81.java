import java.util.ArrayList;
import java.util.HashMap;

class Day81{
    //Intersection of Two arrays with Duplicate Elements (gfg)
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:a)mm.put(x,1);
        for(int x:b){
            if(mm.get(x)!=null && mm.get(x)!=0){
                ans.add(x);
                mm.put(x,0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day81 d = new Day81();
        int[] a = {1,2,2,1}; 
        int[] b = {2,2}; 
        ArrayList<Integer> ans = d.intersectionWithDuplicates(a, b);
        System.out.println(ans);
    }
}