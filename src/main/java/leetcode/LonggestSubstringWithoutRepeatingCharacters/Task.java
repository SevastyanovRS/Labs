package leetcode.LonggestSubstringWithoutRepeatingCharacters;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class Task {

    public static void main(String[] args) {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(5, lengthOfLongestSubstring("tmmzuxt"));
        Assert.assertEquals(4, lengthOfLongestSubstring("uqinntq"));

    }


    public static int lengthOfLongestSubstring(String s) {
        System.out.println("_______________");
        int result = 0;
        int left=0;
        Set<Character> set=new HashSet<>();

        for(int right=0;right<s.length();right++){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                result=Math.max(result,right-left+1);

            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }
        return result;
    }
}
