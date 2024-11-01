class Day23{
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 0;
        char prevChar = ' '; 

        for (char c : s.toCharArray()) {
            if (c == prevChar) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
                prevChar = c;
            }
            if (consecutiveCount <= 2) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Day23 d = new Day23();
        String s = "abbccc";
        System.out.println(d.makeFancyString(s));
    }
}