package com.btanabe.fsdu.parsers;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 7/28/15.
 */
public class ValueExtractor {
    private String inputHtmlString;
    private Pattern valuePattern;
    private String objectClasspath;

    public ValueExtractor(String inputHtmlString, String outputMatchingRegex, String outputClasspath) {
        this(outputMatchingRegex, outputClasspath);
        this.inputHtmlString = inputHtmlString;
    }

    public ValueExtractor(String outputMatchingRegex, String outputClasspath) {
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
//        valuePattern = Pattern.compile(outputMatchingRegex);
        this.objectClasspath = outputClasspath;
    }

    public Object getValue() throws ClassNotFoundException {
        return BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(Class.forName(objectClasspath), String.class), extractValueAsString(inputHtmlString));
    }

    private String extractValueAsString(String inputString) {
        Matcher valueMatcher = valuePattern.matcher(inputString);
        valueMatcher.find();
        return valueMatcher.group();
    }

    public void setInputHtmlString(String inputHtmlString) {
        this.inputHtmlString = inputHtmlString;
    }
}
