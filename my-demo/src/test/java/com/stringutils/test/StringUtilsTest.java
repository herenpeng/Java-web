package com.stringutils.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @description: apache.lang3 StringUtils字符串工具类demo
 * @author: 何任鹏
 * @create: 2020/8/25 21:35
 */
public class StringUtilsTest {

    @Test
    public void test01() {
        String str1 = null;
        String str2 = "";
        String str3 = "\n";
        String str4 = "\u001C";
        String str5 = "字符串";
        String str6 = "  abc  ";
        System.out.println(StringUtils.isBlank(str1));  //true
        System.out.println(StringUtils.isBlank(str2));  //true
        System.out.println(StringUtils.isBlank(str3));  //true
        System.out.println(StringUtils.isBlank(str4));  //true
        System.out.println(StringUtils.isBlank(str5));  //false
        System.out.println(StringUtils.isBlank(str6));  //false
    }


    @Test
    public void test02() {
        String str1 = null;
        System.out.println(StringUtils.isNotBlank(str1));  //false
        String str2 = "";
        System.out.println(StringUtils.isNotBlank(str2));  //false
        String str3 = "\n";
        System.out.println(StringUtils.isNotBlank(str3));  //false
        String str4 = "\u001C";
        System.out.println(StringUtils.isNotBlank(str4));  //false
        String str5 = "字符串";
        System.out.println(StringUtils.isNotBlank(str5));  //true
        String str6 = "  abc  ";
        System.out.println(StringUtils.isNotBlank(str6));  //true
    }

    @Test
    public void test03() {
        String str1 = null;
        System.out.println(StringUtils.isEmpty(str1));  //true
        String str2 = "";
        System.out.println(StringUtils.isEmpty(str2));  //true
        String str3 = "\n";
        System.out.println(StringUtils.isEmpty(str3));  //false
        String str4 = "\u001C";
        System.out.println(StringUtils.isEmpty(str4));  //false
        String str5 = "字符串";
        System.out.println(StringUtils.isEmpty(str5));  //false
        String str6 = "  abc  ";
        System.out.println(StringUtils.isEmpty(str6));  //false
    }

    @Test
    public void test04() {
        String str1 = null;
        System.out.println(StringUtils.isNotEmpty(str1));  //false
        String str2 = "";
        System.out.println(StringUtils.isNotEmpty(str2));  //false
        String str3 = "\n";
        System.out.println(StringUtils.isNotEmpty(str3));  //true
        String str4 = "\u001C";
        System.out.println(StringUtils.isNotEmpty(str4));  //true
        String str5 = "字符串";
        System.out.println(StringUtils.isNotEmpty(str5));  //true
        String str6 = "  abc  ";
        System.out.println(StringUtils.isNotEmpty(str6));  //true
    }


    @Test
    public void test05() {
        String str1 = "abc";
        String str2 = "def";
        String str3 = null;
        String str4 = "";
        String str5 = "123";
        String join = StringUtils.join(str1, str2, str3, str4, str5);
        System.out.println(join);   //abcdef123
    }

    @Test
    public void test06() {
        String str1 = "abc";
        String str2 = "def";
        System.out.println(StringUtils.equals(str1, str2)); //false
        str1 = "";
        str2 = "def";
        System.out.println(StringUtils.equals(str1, str2)); //false
        str1 = null;
        str2 = "";
        System.out.println(StringUtils.equals(str1, str2)); //false
        str1 = null;
        str2 = null;
        System.out.println(StringUtils.equals(str1, str2)); //true
        str1 = "";
        str2 = "";
        System.out.println(StringUtils.equals(str1, str2)); //true
        str1 = "123";
        str2 = "123";
        System.out.println(StringUtils.equals(str1, str2)); //true
    }

    @Test
    public void test07() {
        String str1 = "abc";
        String str2 = "ABC";
        System.out.println(StringUtils.equalsIgnoreCase(str1, str2)); //true
        str1 = "abc";
        str2 = "ABc";
        System.out.println(StringUtils.equalsIgnoreCase(str1, str2)); //true
    }

    @Test
    public void test08() {
        String str1 = "abc 123\nDEF";
        String str2 = " ";
        String[] split1 = StringUtils.split(str1);
        for (String str : split1) {
            System.out.println(str);
        }   // abc  123   DEF
        String str3 = "abc,123,DEF$456";
        String str4 = ",";
        String[] split2 = StringUtils.split(str3, str4);
        for (String str : split2) {
            System.out.println(str);
        }   // abc  123   DEF$456
        String str5 = null;
        String str6 = null;
        String[] split3 = StringUtils.split(str5, str6);
        System.out.println(split3); // null
    }


    @Test
    public void test09() {
        String str1 = "  abcdef  ";
        System.out.println(StringUtils.trim(str1)); //abcdef
        String str2 = "abcdef  ";
        System.out.println(StringUtils.trim(str2)); //abcdef
        String str3 = "  abcdef";
        System.out.println(StringUtils.trim(str3)); //abcdef
        String str4 = "";
        System.out.println(StringUtils.trim(str4)); //      [空字符串]
        String str5 = null;
        System.out.println(StringUtils.trim(str5)); //null
    }

    @Test
    public void test10() {
        String str1 = "abcdef123ghijk";
        String str2 = "23";
        System.out.println(StringUtils.contains(str1, str2)); //true
        str1 = null;
        str2 = null;
        System.out.println(StringUtils.contains(str1, str2)); //false
        str1 = "abcdef";
        str2 = null;
        System.out.println(StringUtils.contains(str1, str2)); //false
    }

}
