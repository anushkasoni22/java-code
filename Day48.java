import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Day48{
    //Maximum Product Subarray
    int maxProduct(int[] arr) {
        int ans=Integer.MIN_VALUE,left=1,right=1,n=arr.length;
        for(int i=0;i<n;i++){
            left*=arr[i];
            right*=arr[n-1-i];
            ans=Math.max(ans,Math.max(left,right));
            if(left==0)left=1;
            if(right==0)right=1;
        }
        return ans;
    }

    //Sliding Puzzle
    public int slidingPuzzle(int[][] board) {
        int[][] dirs = { {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4} };
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int moves = 0;

        String ans = "123450";
        StringBuilder start = new StringBuilder();
        
        // Convert the board into a string representation
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        q.add(start.toString());
        visited.add(start.toString());

        // Breadth-first search (BFS)
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String curr = q.poll();
                if (curr.equals(ans)) return moves;

                int idx = curr.indexOf('0');
                for (int x : dirs[idx]) {
                    StringBuilder s = new StringBuilder(curr);
                    // Swap characters
                    char temp = s.charAt(x);
                    s.setCharAt(x, s.charAt(idx));
                    s.setCharAt(idx, temp);

                    String next = s.toString();
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day48 d = new Day48();
        int arr[] = {-2, 6, -3, -10, 0, 2};
        System.out.println(d.maxProduct(arr));

        int board[][] = {{1,2,3},{4,0,5}};
        System.out.println(d.slidingPuzzle(board));
    }
}