package com.ww.library.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isEmpty(String str) {
        if ((str == null) || ("".equals(str)) || ("null".equals(str.toLowerCase()))) {
            return true;
        }
        String pattern = "";
        Pattern p = Pattern.compile(pattern, 34);
        Matcher m = p.matcher(str);
        return !m.find();
    }
    public static void main(String args[]){


    }


}
