package leetcode.romantointeger;

import org.junit.Assert;

import java.util.Map;
import java.util.Set;

public class RomantoInteger {

    static final Map<Character, Integer> dictionary = Map.of('I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static void main(String[] args) {
        Assert.assertEquals(1993,   romanToInt4("MCMXCIIV"));
        Assert.assertEquals(3,      romanToInt4("III"));
        Assert.assertEquals(58,     romanToInt4("LVIII"));

    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        boolean isVorX = false;
        boolean isCorL = false;
        boolean isMorD = false;

        for (int i = chars.length - 1; i >= 0; i--) {
            char character = chars[i];

            if (character == 'V' || character == 'X') {
                isVorX = true;
            } else if (character == 'L' || character == 'C') {
                isCorL = true;
            } else if (character == 'D' || character == 'M') {
                isMorD = true;
            }

            if (character == 'I' && isVorX) {
                result = result - 1;
                isMorD = false; isCorL = false;
            } else if (character == 'X' && isCorL) {
                result = result - 10;
                isCorL = false; isMorD = false;
            } else if (character == 'C' && isMorD) {
                result = result - 100;
                isCorL = false; isVorX = false;
            } else {
                result = result + dictionary.get(character);
            }
        }
        return result;
    }

    public static int romanToInt2(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public static int romanToInt3(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

    static int romanToInt4(String s) {
        int result = 0;

        Character n = null;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (n != null && n == c) {
                result -= dictionary.getOrDefault(c, 0);
                continue;
            }
            if (c == 'V' || c == 'X') {
                n = 'I';
            } else if (c == 'L' || c == 'C') {
                n = 'X';
            } else if (c == 'D' || c == 'M') {
                n = 'C';
            }
            result += dictionary.getOrDefault(c, 0);
        }

        return result;
    }

}
