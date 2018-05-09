/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressrle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Re5
 */
public class RunLengthEncoding {
    /*
        Run Length Encoding Implementation
        https://stackoverflow.com/questions/11442162/java-run-length-encoding
    */
    public static String encode(String source) {
        StringBuilder dest = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i + 1 < source.length()
                    && source.charAt(i) == source.charAt(i + 1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }

    public static String decode(String source) {
        StringBuilder dest = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher;
        matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
    }
}
