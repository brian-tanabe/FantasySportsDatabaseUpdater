package com.btanabe.fsdu.parsers;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 7/28/15.
 */
public class ValueExtractor<T> {
    protected Pattern valuePattern;
    protected Class<T> objectClasspath;
    protected Matcher valueMatcher;

    public ValueExtractor(String outputMatchingRegex, Class<T> outputClasspath) {
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
        this.objectClasspath = outputClasspath;
    }

    public Object getValue() throws ClassNotFoundException {
        String objectValue = extractValueAsString();
        return objectValue == null ? null : BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(objectClasspath, String.class), objectValue);
    }

    protected String extractValueAsString() {
        return valueMatcher.find() ? valueMatcher.group() : null;
    }

    public void setInputStringToSearch(String inputStringToSearch) {
        valueMatcher = valuePattern.matcher(inputStringToSearch);
    }
}
