public class Day25 {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        return false;     
        StringBuilder sb = new StringBuilder(s);    
        for(int i=0; i<s.length(); i++)
        {
          if(sb.toString().equals(goal))
              return true; 
          char ch = sb.charAt(0);  
          sb.deleteCharAt(0);
          sb.append(ch);  
        }
            return false;
    }
    public static void main(String[] args) {
        Day25 day = new Day25();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(day.rotateString(s, goal));
    }
}
