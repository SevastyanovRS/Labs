package codewars.merged_string_checker;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MergedStringChecker {
    public static void main(String[] args) {
        assertTrue("codewars can be created from code and wars", MergedStringChecker.isMerge("codewars", "code", "wars"));
        assertTrue("codewars can be created from cdwr and oeas", MergedStringChecker.isMerge("codewars", "cdwr", "oeas"));
        assertFalse("Codewars are not codwars", MergedStringChecker.isMerge("codewars", "cod", "wars"));
        assertFalse("Codewars are not codewarss", MergedStringChecker.isMerge("codewars", "code", "warss"));
    }

    public static boolean isMerge(String s, String part1, String part2) {
        List<Integer> coll = s.chars().boxed().collect(Collectors.toList());
        List<Integer> integers = (part1 + part2).chars().boxed().toList();
        coll.removeAll(integers);

        return coll.isEmpty();
    }
}
