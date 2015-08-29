package com.btanabe.fsdu.parsers;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 7/28/15.
 */
public class ValueExtractor {
    protected Pattern valuePattern;
    protected String objectClasspath;
    protected Matcher valueMatcher;

    public ValueExtractor(String outputMatchingRegex, String outputClasspath) {
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
        this.objectClasspath = outputClasspath;
    }

    public Object getValue() throws ClassNotFoundException {
        Class outputClazz = Class.forName(objectClasspath);
        String objectValue = extractValueAsString();
        return objectValue == null ? null : BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(outputClazz, String.class), extractValueAsString());
    }

    protected String extractValueAsString() {
        return valueMatcher.find() ? valueMatcher.group() : null;
    }

    public void setInputStringToSearch(String inputStringToSearch) {
        valueMatcher = valuePattern.matcher(inputStringToSearch);
    }
}
