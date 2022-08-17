package codewars.strip_comment;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class StripComment {

    public static void main(String[] args) {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComment.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComment.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );
    }



    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder sb = new StringBuilder("[");
        Arrays.stream(commentSymbols).forEach(sb::append);
        sb.append("].*");
        StringJoiner joiner = new StringJoiner("\n");
        Arrays.stream(text.split("\n"))
                .map(x -> x.replaceAll(sb.toString(), "").stripTrailing())
                .forEach(joiner::add);
        return joiner.toString();
    }


}
