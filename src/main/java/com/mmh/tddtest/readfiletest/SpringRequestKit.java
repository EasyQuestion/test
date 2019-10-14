package com.mmh.tddtest.readfiletest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 10:18
 */
public class SpringRequestKit {
    public static String readData(HttpServletRequest request) {
        try (BufferedReader br = request.getReader()) {
            StringBuilder ret;
            String line = br.readLine();
            if (line == null) {
                return "";
            } else {
                ret = new StringBuilder();
                ret.append(line);
            }

            while ((line = br.readLine()) != null) {
                ret.append('\n').append(line);
            }
            return ret.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
