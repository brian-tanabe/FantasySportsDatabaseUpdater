package com.btanabe.fsdu.parsers;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Brian on 7/28/15.
 * <p>
 * I'm pretty sure I'm doing a bad job at unknowingly implementing Consumers, FunctionalInterfaces, and Predicates in this class:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach6
 */
public class ValueExtractor<OutputClazz> implements Function<String, OutputClazz> {
    protected Pattern valuePattern;
    protected Class<OutputClazz> objectClasspath;
    protected Matcher valueMatcher;

    public ValueExtractor(String outputMatchingRegex, Class<OutputClazz> outputClasspath) {
        valuePattern = Pattern.compile(outputMatchingRegex, Pattern.MULTILINE);
        this.objectClasspath = outputClasspath;
    }

    @Override
    public OutputClazz apply(String inputStringToSearch) {
        setMatcherStringToSearch(inputStringToSearch);
        return findNextMatch();
    }

    @Deprecated
    public OutputClazz getValue() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        String objectValue = valueMatcher.find() ? valueMatcher.group() : null;
        return objectValue == null ? null : BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(objectClasspath, String.class), objectValue);
    }

    private void setMatcherStringToSearch(final String inputStringToSearch) {
        valueMatcher = valuePattern.matcher(inputStringToSearch);
    }

    protected OutputClazz findNextMatch() {
        String objectValue = valueMatcher.find() ? valueMatcher.group() : null;
        return objectValue == null ? null : BeanUtils.instantiateClass(ClassUtils.getConstructorIfAvailable(objectClasspath, String.class), objectValue);
    }

    @Deprecated
    public void setInputStringToSearch(String inputStringToSearch) {
        valueMatcher = valuePattern.matcher(inputStringToSearch);
    }
}
