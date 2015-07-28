package com.btanabe.fsdu.parser;

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
    private String objectType;

    public ValueExtractor(String inputHtmlString, String outputMatchingRegex, String objectType) {
        this.inputHtmlString = inputHtmlString;
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
        this.objectType = objectType;

    }

    public Object getValue() throws ClassNotFoundException {
        return BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(Class.forName(objectType), String.class), extractValueAsString(inputHtmlString));
    }

    private String extractValueAsString(String inputString) {
        Matcher valueMatcher = valuePattern.matcher(inputString);
        valueMatcher.find();
        return valueMatcher.group();
    }
}
