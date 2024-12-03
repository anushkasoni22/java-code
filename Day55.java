class Day55{
    //Adding Spaces to a String
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder(s.length() + spaces.length);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                res.append(' ');
                j++;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }    
    
    //Min Chars to Add for Palindrome
    public int minChar(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] lps = buildLPS(combined);
        return s.length() - lps[lps.length - 1];
    }

    private static int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int length = 0; 
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Day55 d = new Day55();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(d.addSpaces(s, spaces));

        String s1 = "aacecaaa";
        System.out.println(d.minChar(s1));
    }
}   
