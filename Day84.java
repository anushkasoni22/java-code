import java.util.*;
class Day84{
    //Print Anagrams Together(gfg)
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        
        for(String i : arr){
            char ch[] = i.toCharArray();
            Arrays.sort(ch);
            
            String str = new String(ch);
            
            if(!mp.containsKey(str)){
                mp.put(str, new ArrayList<>());
            }
            mp.get(str).add(i);
        }
        ans.addAll(mp.values());
        return ans;
    }

    //Maximum Score After Splitting a String
    public int maxScore(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            result = Math.max(result, zeros - ones);
        }

        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return result + ones;
    }

    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        Day84 d = new Day84();
        ArrayList<ArrayList<String>> ans = d.anagrams(arr);
        System.out.println(ans);

        String s = "011101";
        int result = d.maxScore(s);
        System.out.println(result);
    }
}