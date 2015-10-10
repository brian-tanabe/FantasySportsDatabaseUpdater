package com.btanabe.fsdu.processors;

import com.btanabe.fsdu.parsers.ValueExtractor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Brian on 10/10/15.
 */
public class TransformingValueExtractor<T> extends ValueExtractor {

    private ValueTransformer outputValueTransformer;

    public TransformingValueExtractor(String outputMatchingRegex, Class<T> outputClasspath, ValueTransformer outputValueTransformer) {
        super(outputMatchingRegex, outputClasspath);

        this.outputValueTransformer = outputValueTransformer;
    }

    @Override
    public Object getValue() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        return outputValueTransformer.transformValue(super.getValue());
    }
}
