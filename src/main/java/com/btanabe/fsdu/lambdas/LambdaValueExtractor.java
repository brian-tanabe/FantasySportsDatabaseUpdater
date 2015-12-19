package com.btanabe.fsdu.lambdas;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 12/12/15.
 */
public class LambdaValueExtractor<OutputClazz> implements Function<String, OutputClazz> {

    protected Pattern valuePattern;
    protected Class<OutputClazz> objectClasspath;
    protected Matcher valueMatcher;

    public LambdaValueExtractor(String outputMatchingRegex, Class<OutputClazz> outputClasspath) {
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
        this.objectClasspath = outputClasspath;
    }

    @Override
    public OutputClazz apply(String inputStringToSearch) {
        String objectValue = extractValueAsString(inputStringToSearch);
        return objectValue == null ? null : BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(objectClasspath, String.class), objectValue);
    }

    protected String extractValueAsString(String inputStringToSearch) {
        valueMatcher = valuePattern.matcher(inputStringToSearch);
        return valueMatcher.find() ? valueMatcher.group() : null;
    }
}
