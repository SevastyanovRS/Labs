package leetcode.LengthOfLastWord;

import org.junit.Assert;

public class LengthOfLastWord {

    public static void main(String[] args) {
        Assert.assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
        Assert.assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
