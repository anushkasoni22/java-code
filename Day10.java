import java.math.BigInteger;

public class Day10 {
    String roundToNearest(String str) {
        // Preserve the leading zeros
        String leadingZeros = "";
        int idx = 0;
        
        // Count the leading zeros
        while (idx < str.length() && str.charAt(idx) == '0') {
            leadingZeros += "0";
            idx++;
        }
        
        // Process the non-zero part of the number
        String nonZeroPart = str.substring(idx);
        
        // If all digits are zero, return the leading zeros
        if (nonZeroPart.isEmpty()) {
            return leadingZeros;
        }
        
        // Convert the non-zero part to BigInteger for rounding
        BigInteger num = new BigInteger(nonZeroPart);
        
        // Find quotient and remainder when dividing by 10
        BigInteger[] divAndRemainder = num.divideAndRemainder(BigInteger.TEN);
        BigInteger quotient = divAndRemainder[0];
        BigInteger remainder = divAndRemainder[1];
        
        // If remainder is less than or equal to 5, round down; otherwise round up
        if (remainder.compareTo(BigInteger.valueOf(5)) <= 0) {
            // Round down
            num = quotient.multiply(BigInteger.TEN);
        } else {
            // Round up
            num = quotient.add(BigInteger.ONE).multiply(BigInteger.TEN);
        }
        
        // Convert the result back to string
        String roundedResult = num.toString();
        
        // Return the leading zeros concatenated with the rounded result
        return leadingZeros + roundedResult;
    }

    public static void main(String[] args) {
        Day10 d = new Day10();
        String str = "15";
        System.out.println(d.roundToNearest(str));
    }    
}
