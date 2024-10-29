class Day20{
    public int myAtoi(String s) {
        if(s==null) return 0;

        s=s.trim(); //to remove the whitespaces
        
        if(s.length()==0) return 0;
        
        int sign = +1;
        long ans = 0;
        if(s.charAt(0) == '-') sign = -1;
        
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
		
		// initiate the starting pointer
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
		
        while(i < s.length()) {
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            ans = ans * 10 + s.charAt(i)-'0';
            // check the conditions
            if(sign == -1 && -1*ans < MIN) return MIN;
            if(sign == 1 && ans > MAX) return MAX;
            
            i++;
        }
        
        return (int)(sign*ans);
    }
    public static void main(String[] args) {
        Day20 d = new Day20();
        System.out.println(d.myAtoi("42"));
        System.out.println(d.myAtoi("   -42"));
        System.out.println(d.myAtoi("4193 with words"));
        System.out.println(d.myAtoi("words and 987"));
        System.out.println(d.myAtoi("-91283472332"));
    }
}