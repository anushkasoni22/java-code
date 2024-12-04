public class Day56 {
    //Strings Rotations of Each Other (gfg)
    public boolean areRotations(String s1, String s2) {
        String str = s1+s1;
        int i=0, j=0;
        while(i<str.length() && j<s2.length()){
            if(str.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return (j == s2.length());   
    }

    //Make String a Subsequence Using Cyclic Increments(leetcode)
    public boolean canMakeSubsequence(String str1, String str2) {
        int source = str1.length();
        int target = str2.length();
        int i=0, j=0;

        while(i < source && j < target){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            if(ch1 == ch2 || (ch1 == 'z' && ch2 == 'a') || (ch1+1 == ch2)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j == target;
    }

    public static void main(String[] args) {
        Day56 d = new Day56();
        String s1 = "abcd", s2 = "cdab";
        System.out.println(d.areRotations(s1, s2));

        String str1 = "abc" , srt2 = "ad";
        System.out.println(d.canMakeSubsequence(str1, srt2));
    }    
}
