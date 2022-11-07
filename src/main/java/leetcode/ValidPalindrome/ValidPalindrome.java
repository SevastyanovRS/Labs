package leetcode.ValidPalindrome;

import org.junit.Assert;

public class ValidPalindrome {

    public static void main(String[] args) {
        Assert.assertFalse(isPalindrome2("azAZ19"));
        Assert.assertTrue(isPalindrome2("A man, a plan, a canal: Panama"));
        Assert.assertTrue(isPalindrome2("abvvba"));
        Assert.assertTrue(isPalindrome2(" "));
        Assert.assertFalse(isPalindrome2("ab"));
        Assert.assertFalse(isPalindrome2("0P"));
        Assert.assertTrue(isPalindrome2(".,"));
        Assert.assertFalse(isPalindrome2("race a car"));

        //abvba
    }

    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int middle = s1.length()/2;
        for (int i = 0; i < middle; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    //97 122 65 90 49 57
    public static boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int start = 0;
        int last = s.length()-1;

        while (start < last) {

            while (start < last && !((97 <= s.charAt(start) && s.charAt(start) <= 122)
                    || (48 <= s.charAt(start) && s.charAt(start) <= 57))) {
                start++;
            }
            while (start < last && !((97 <= s.charAt(last) && s.charAt(last) <= 122)
                    || (48 <= s.charAt(last) && s.charAt(last) <= 57))) {
                last--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))) {
                return false;
            }
            start++;
            last--;

        }
        return true;
    }
}
