package com.example.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsUtil {

    public static String capitalizeWords(String input) {
        return StringUtils.capitalize(input.toLowerCase());
    }
}
