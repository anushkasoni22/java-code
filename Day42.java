import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Day42{
    //Take K of Each Character From Left and Right(leetcode)
    public static int takeCharacters(String s, int k) {
        int[] count = new int[3];
        char[] ch = s.toCharArray();
        int len = ch.length;
        int left = 0;
        for (left = 0; left < len; left++) {
            count[ch[left] - 'a']++;
            if (isValidCount(count, k)) {
                break;
            }
        }
        
        if (left == len) {
            return -1;
        }
        
        int currentCount = left + 1;
        int minCount = currentCount;
        int right = len - 1;
        
        while (left >= 0) {
            int currentChar = ch[left] - 'a';
            
            if (count[currentChar] == k) {
                while (ch[left] != ch[right]) {
                    count[ch[right] - 'a']++;
                    right--;
                    currentCount++;
                }
                right--;
            } else {
                count[currentChar]--;
                currentCount--;
                minCount = Math.min(currentCount, minCount);
            }
            left--;
        }
        
        return minCount;
    }
    
    private static boolean isValidCount(int[] count, int k) {
        return count[0] >= k && count[1] >= k && count[2] >= k;
    }

    //Majority Element II(gfg)
    public static List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) result.add(num);
            return result;
        }
        
        List<Integer> ans = new ArrayList<>();
        int ele1 = nums[0], ele2 = nums[1], c1 = 0, c2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                c1++;
            } else if (nums[i] == ele2) {
                c2++;
            } else if (c1 == 0) {
                ele1 = nums[i];
                c1++;
            } else if (c2 == 0) {
                ele2 = nums[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }    
        c1=0; 
        c2=0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele1) c1++;
            else if(nums[i] == ele2) c2++;
        }
        if(c1>(n/3)) ans.add(ele1);
        if(c2>(n/3)) ans.add(ele2);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s, k));

        int arr[] = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(arr));
    }
}