package leetcode.palindrome_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class PalindromeNumber {
    public static void main(String[] args) {
        assertEquals(true, isPalindrome2(12621));
    }

    public static boolean isPalindrome2(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int center = number.length()/2;
        int maxIndex = number.length()-1;
        for(int i = 0; i < center; i++) {
            if(number.charAt(i) != number.charAt(maxIndex - i)) return false;
        }
        return true;
    }
}
