class Day43{
    //Count Unguarded Cells in the Grid(leetcode)
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 = free, 1 = guard, 2 = wall, 3 = guardable
        
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        
        for (int[] guard : guards) {
            markGuarded(grid, guard[0], guard[1], m, n);
        }
        
        int res = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void markGuarded(int[][] grid, int r, int c, int m, int n) {
        for (int row = r + 1; row < m; row++) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int row = r - 1; row >= 0; row--) {
            if (grid[row][c] == 1 || grid[row][c] == 2) break;
            grid[row][c] = 3;
        }
        for (int col = c + 1; col < n; col++) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
        for (int col = c - 1; col >= 0; col--) {
            if (grid[r][col] == 1 || grid[r][col] == 2) break;
            grid[r][col] = 3;
        }
    }

    //Stock Buy and Sell – Multiple Transaction Allowed
    public int maximumProfit(int prices[]) {
        int ans=0, n = prices.length;
        for(int i=1; i<n; i++){
            if(prices[i] > prices[i-1]){
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day43 d = new Day43 ();
        int m=4, n=6, guards[][] = {{0,0},{1,1},{2,3}}, walls[][] = {{0,1},{2,2},{1,4}};
        System.out.println(d.countUnguarded(m, n, guards, walls));

        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(d.maximumProfit(prices));
    }
}