package leetcode.validParentheses;

import org.junit.Assert;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Assert.assertTrue(isValid("{}[]()"));
        Assert.assertFalse(isValid("{]()"));
        Assert.assertTrue(isValid("{[]}()"));
        Assert.assertTrue(isValid("{[]()}"));
        Assert.assertFalse(isValid("["));
        Assert.assertFalse(isValid("]"));
    }

    private static final Map<Character, Character> CLOSE_OPEN_BRACKETS = Map.of('}', '{', ']', '[', ')', '(');

    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (CLOSE_OPEN_BRACKETS.containsKey(c) && !brackets.isEmpty()) {
                if (!CLOSE_OPEN_BRACKETS.get(c).equals(brackets.pop())) return false;
            } else {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }

    //slowly
    public boolean isValid2(String s) {
        Stack<Character> st=new Stack<Character>();
        for(char a:s.toCharArray())
        {

            //Check if stack not empty and the top element corresponds to curr char
            if(!st.isEmpty() && (st.peek()==a-1 || st.peek()==a-2))
                st.pop();
                //else these migh be starting brackets or unsatisfied closing brackets
            else
                st.push(a);
        }

        return st.isEmpty();
    }

}
