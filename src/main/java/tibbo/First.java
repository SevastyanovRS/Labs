package tibbo;

import org.junit.Assert;

import java.util.*;

public class First {

    /**
     * sort input string according to the order of characters in alphabet list
     * complexity - O(n)
     * any character in list
     * if some character exists in input string and alphabet list does not contain it,
     * than you need to put it to end of resulting string in any order
     */
    public static void main(String[] args) {
        Assert.assertEquals("aabcde", sort("bacaed", Arrays.asList('a', 'b', 'c', 'd', 'e')));
        Assert.assertEquals("xbbaaaac", sort("abacabax", Arrays.asList('x', 'b', 'f')));
        Assert.assertEquals("", sort("", Arrays.asList('x', 'b', 'f')));

        Assert.assertThrows(IllegalArgumentException.class, () -> sort("abacabax", null));
        Assert.assertThrows(IllegalArgumentException.class, () -> sort(null, Arrays.asList('x', 'b', 'f')));
        Assert.assertThrows(IllegalArgumentException.class, () -> sort(null, null));
    }

    public static String sort(String input, List<Character> alphabet) {
        if (alphabet == null || input == null) throw new IllegalArgumentException("Args must be not null");
        if (input.isEmpty()) return "";


        StringBuilder stringBuilder = new StringBuilder();

        HashMap<Character, Integer> characterCountMap = new HashMap<>();
        input.chars().mapToObj(c -> (char) c).forEach(c -> characterCountMap.merge(c, 1, Integer::sum));

        alphabet.forEach(c -> {
            if (characterCountMap.containsKey(c)) {
                stringBuilder.append(c.toString().repeat(characterCountMap.remove(c)));
            }
        });

        characterCountMap.forEach((c, v) -> stringBuilder.append(c.toString().repeat(v)));

        return stringBuilder.toString();
    }


}
