import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Day44{
    //Flip Columns For Maximum Number of Equal Rows(leetcode)
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patFreq = new HashMap<>();
        
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        return Collections.max(patFreq.values());
    }

    //Stock Buy and Sell – Max one Transaction Allowed(gfg)
    public int maximumProfit(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0; i<prices.length; i++){
            if(buyprice < prices[i]){
                int profit = prices[i] - buyprice;
                maxprofit = Math.max(profit, maxprofit);
            }
            else{
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Day44 d = new Day44();
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(d.maxEqualRowsAfterFlips(matrix)); 

        int prices[] = {7,10,1,3,6,9,2};
        System.out.println(d.maximumProfit(prices)); 
    }
}