package com.babar.utils;

/**
 * @author babar
 * @since 3/26/17.
 */
public class Util {

    public static boolean isAnyNull (Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }

        return false;
    }
}
