class Day53{
    //Check If N and Its Double Exist(leetcode)
    public static boolean checkIfExist(int[] arr) {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i]==arr[j]*2 ||arr[i]*2==arr[j] )return true;
            }
        }
        return false;
    }

    //Non Repeating Character(gfg)
    public static char isNonRepeating(String s) {
        int[] charCount = new int[26];
        
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a'] == 1) {
                return c;
            }
        }
        return '$';
    } 

    public static void main(String[] args) {
        Day53 d = new Day53();
        int[] arr = {10,2,5,3};
        System.out.println(d.checkIfExist(arr));

        String s = "geeksforgeeks";
        System.out.println(d.isNonRepeating(s));
    }
}