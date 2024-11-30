import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Day52{
    //Valid Arrangement of Pairs(leetcode)
    // DFS using stack
    public int[][] validArrangement(int[][] pairs) {
            Map<Integer, List<Integer>> adj = new HashMap<>();
            Map<Integer, Integer> indegree = new HashMap<>();
            Map<Integer, Integer> outdegree = new HashMap<>();
    
            for (int[] edge : pairs) {
                int u = edge[0];
                int v = edge[1];
                
                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
                indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            }
    
            int startNode = pairs[0][0];
            for (int node : adj.keySet()) {
                if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                    startNode = node;
                    break;
                }
            }
    
            List<Integer> eulerPath = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(startNode);
    
            while (!stack.isEmpty()) {
                int curr = stack.peek();
                if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                    int neighbor = adj.get(curr).remove(adj.get(curr).size() - 1);
                    stack.push(neighbor);
                } else {
                    eulerPath.add(curr);
                    stack.pop();
                }
            }
    
            Collections.reverse(eulerPath);
            int[][] result = new int[eulerPath.size() - 1][2];
            for (int i = 0; i < eulerPath.size() - 1; i++) {
                result[i][0] = eulerPath.get(i);
                result[i][1] = eulerPath.get(i + 1);
            }
            return result;
        }
    
        //using recursion
        /* private Map<Integer, List<Integer>> adj = new HashMap<>();
        // List to store the Eulerian path
        private List<Integer> eulerPath = new ArrayList<>();
    
        // Recursive DFS function to find the Eulerian path
        private void dfs(int node) {
            while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
                int nextNode = adj.get(node).remove(adj.get(node).size() - 1);  // Remove the edge after visiting
                dfs(nextNode);  // Recursive DFS call
            }
            eulerPath.add(node);  // Add node to Euler path after all edges are visited
        }
    
        public int[][] validArrangement(int[][] pairs) {
            // Step-1: Build adjacency list and calculate in-degree & out-degree
            Map<Integer, Integer> indegree = new HashMap<>();
            Map<Integer, Integer> outdegree = new HashMap<>();
    
            for (int[] edge : pairs) {
                int u = edge[0];
                int v = edge[1];
    
                adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
                indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            }
    
            // Step-2: Find the start node of the Eulerian path
            int startNode = pairs[0][0];  // default start node
            for (int node : adj.keySet()) {
                if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                    startNode = node;  // Node with outdegree > indegree by 1
                    break;
                }
            }
    
            // Step-3: Perform DFS from the start node to find the Eulerian path
            dfs(startNode);
    
            // Step-4: Build the result from the Eulerian path
            Collections.reverse(eulerPath);
            int[][] result = new int[eulerPath.size() - 1][2];
            for (int i = 0; i < eulerPath.size() - 1; i++) {
                result[i][0] = eulerPath.get(i);
                result[i][1] = eulerPath.get(i + 1);
            }
    
            return result;
        } */
    
        //Anagram
        public static boolean areAnagrams(String s1, String s2) {
            char s1chars[] = s1.toCharArray();
            char s2chars[] = s2.toCharArray();
            
            Arrays.sort(s1chars);
            Arrays.sort(s2chars);
            
            return Arrays.equals(s1chars, s2chars);
        }
    
        public static void main(String[] args) {
            Day52 d = new Day52();
            //Test cases for validArrangement function
            int pairs[][] = {{5,1}, {4,5}, {11,9}, {9,4}};
            int result[][] = d.validArrangement(pairs); 
            for (int i = 0; i < result.length; i++) {
                System.out.print("{" + result[i][0] + "," + result[i][1] + "}");
                if (i < result.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
    
        //Test cases for areAnagrams function
        String s1 = "geeks";
        String s2 = "seekg";
        System.out.println(areAnagrams(s1, s2));
    }    
}