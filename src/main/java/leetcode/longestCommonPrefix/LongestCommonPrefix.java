package leetcode.longestCommonPrefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        return strs[0].substring(0, getIndex(strs[0], strs));
    }

    public static int getIndex(String reference, String[] strs) {
        for (int cursor = 0; cursor < reference.length(); cursor++) {
            char ch = reference.charAt(cursor);
            for(int str = 1; str < strs.length; str++) {
                String element = strs[str];
                if (element.length()-1 >= cursor) {
                    if (element.charAt(cursor) != ch) {
                        return cursor;
                    }
                } else return cursor;
            }
        }
        return reference.length();
    }

    public String longestCommonPrefix_best(String[] strs) {
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}

