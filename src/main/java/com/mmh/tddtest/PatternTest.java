package com.mmh.tddtest;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;


/**
 * @author muminghui
 * @date 2019/6/17 9:51
 */
public class PatternTest {

    //----------不建议使用-----------------------------------
//    public static boolean checkEmail(String email) {
//        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
//        return Pattern.matches(regex, email);
//    }

    //-----------预编译------------------------------
//    private static final String regexRule = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
//    private static final Pattern pattern = Pattern.compile(regexRule);
//
//    private static Boolean checkEmail(String content) {
//        Matcher m = pattern.matcher(content);
//        if (m.matches()) {
//            return true;
//        }
//        return false;
//    }

    //---------------------------------------------

    private static Boolean checkEmail(String content){
        Perl5Matcher matcher = new Perl5Matcher();
        Perl5Compiler compiler = new Perl5Compiler();
        Pattern pattern;
        try {
            pattern = compiler.compile("\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?");
        } catch (MalformedPatternException e) {
            throw new RuntimeException(e);
        }
        return matcher.matches(content, pattern) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(checkEmail("2425@qq.com.aaa"));
    }

}
