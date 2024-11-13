import java.util.Arrays;

public class Day35 {
    //Count the Number of Fair Pairs
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
    
        for (int i = 0; i < nums.length; i++) {
            int lwr = lower - nums[i];
            int upr = upper - nums[i];
    
            int left = lowerBound(nums, i + 1, lwr);
            int right = upperBound(nums, i + 1, upr);
    
            ans += right - left;
        }
        return ans;
    }
    
    private static int lowerBound(int[] nums, int start, int target) {
        int left = start, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private static int upperBound(int[] nums, int start, int target) {
        int left = start, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    //Intersection Point in Y Shaped Linked Lists
    public static int lengthoflists(Node head){
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    public static void main(String[] args) {
    
        int nums[] = {0,1,7,4,4,5};
        int lower = 3, upper = 6;
        System.out.println(countFairPairs(nums,lower,upper));

        Node common = new Node(15);
        common.next = new Node(30);

        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = common;

        Node head2 = new Node(3);
        head2.next = common;

        Intersect intersect = new Intersect();
        int intersectionData = intersect.intersectPoint(head1, head2);
        System.out.println("The intersection point data is: " + intersectionData); // Output: 15
    }
}

// Function to find intersection point in Y shaped Linked Lists
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Intersect {
    // Function to calculate the length of the linked list
    public static int lengthoflists(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    // Function to find intersection point in Y-shaped linked lists
    int intersectPoint(Node head1, Node head2) {
        // Calculate lengths of both linked lists
        int len1 = lengthoflists(head1);
        int len2 = lengthoflists(head2);

        // Align both lists to the same starting point
        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }
        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }

        // Traverse both lists and find the intersection point
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data; // Intersection point found
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1; // No intersection point found
    }
}