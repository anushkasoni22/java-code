class Day21{
    public static int evenlyDivides(int N){
        // code here
        int originalNumber = N;
        int count = 0;

        while (N > 0) {
            int digit = N % 10;  
            N /= 10;

            if (digit != 0 && originalNumber % digit == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int N = 2446;
        int result = evenlyDivides(N);
        System.out.println(result); // Output: 2
    }
}