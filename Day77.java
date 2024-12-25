import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Day77{
    //Find Largest Value in Each Tree Row(leetcode)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
      
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
           
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                max = Math.max(max, curr.val);
            }
            ans.add(max);
        }
        return ans;
    }

    //Set Matrix Zeroes
    public void setMatrixZeroes(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        boolean firstColZero = false;

        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 0) firstColZero = true;
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
            if (firstColZero) {
                mat[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Day77 d = new Day77();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(d.largestValues(root));

        int mat[][] = {{1,-1,1}, {-1,0,1},{1,-1,1}};
        d.setMatrixZeroes(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}