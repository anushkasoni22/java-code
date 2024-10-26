class Day17{
    public boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        while(temp > 0){
            int lastdigit = temp % 10;
            rev = (rev*10) + lastdigit;
            temp = temp/10;
        }
        if(x == rev){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Day17 d = new Day17();
        System.out.println(d.isPalindrome(121));
        System.out.println(d.isPalindrome(-121));
        System.out.println(d.isPalindrome(10));
    }
}