/*You are given an integer num. You can swap two digits at most once to get the maximum valued number.
Return the maximum valued number you can get. */
public class Day8 {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        
        int maxEle = num; // Start with the initial number
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                // Only swap if the character at j is greater than the character at i
                if (arr[i] < arr[j]) {
                    // Swap characters at indices i and j
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    
                    // Update maxEle with the new value if it's higher
                    maxEle = Math.max(maxEle, Integer.parseInt(new String(arr)));
                    
                    // Swap back to revert to original configuration
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        
        return maxEle;
    }
    public static void main(String args[]){
        Day8 d = new Day8();
        int num = 2736;
        System.out.println(d.maximumSwap(num));
    }
}
