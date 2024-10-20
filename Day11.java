public class Day11{
    /*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0. */

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10; // Get the last digit
            x /= 10; // Remove the last digit from x

            // Check for overflow or underflow before adding the digit
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.  MAX_VALUE / 10 && digit > 7)) {
                return 0; // Return 0 if overflow occurs
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Return 0 if underflow occurs
            }

            reversed = reversed * 10 + digit; // Append the digit to the reversed number
        }

        return reversed;
    }

    public static void main(String[] args) {
        Day11 d = new Day11();
        int x = 12345;
        System.out.println(d.reverse(x));
    }
}