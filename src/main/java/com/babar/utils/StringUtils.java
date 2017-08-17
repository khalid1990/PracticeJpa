package com.babar.utils;

/**
 * @author babar
 * @since 8/2/17.
 */
public class StringUtils {

    public static boolean isAnyEmpty(String... strings) {
        for (String s : strings) {
            if (isEmpty(s)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public static boolean isContained(String base, String comparing) {

        return isEmpty(base) || isEmpty(comparing) ? false : base.toLowerCase().contains(comparing.toLowerCase());
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
