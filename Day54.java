import java.util.ArrayList;

class Day54{
    //Check If a Word Occurs As a Prefix of Any Word in a Sentence(leetcode)
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i=0;
        
        for(String str : sentence.split(" ")){
            if(str.startsWith(searchWord)){                
                return i+1;
            }
            i++;
        }
        return -1;
    }

    //Search Pattern (KMP-Algorithm)(gfg)
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int m = pat.length();
        int n = txt.length();
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);

        int i = 0; 
        int j = 0; 
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
 
    private static void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0; 
        int i = 1;
        lps[0] = 0; 

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }    
    }

    public static void main(String[] args) {
        Day54 d = new Day54();
        System.out.println(d.isPrefixOfWord("i love eating burger", "burg")); //3

        System.out.println(d.search("ab", "abcab"));     
    }
}