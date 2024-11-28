class Day50{
    //implement Atoi(gfg)
    public int myAtoi(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++){
            if(i == 0 && s.charAt(i) == '-'){
                continue;
            }
            if(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <= 9){
                num = num*10 + (s.charAt(i)-'0');
            }
            else{
                return -1;
            }
        }
        if(s.charAt(0) == '-')
        num*= -1;
        return num;
    }
    public static void main(String[] args) {
        Day50 d = new Day50();
        String s = "-1234";
        System.out.println(d.myAtoi(s));
    }
}