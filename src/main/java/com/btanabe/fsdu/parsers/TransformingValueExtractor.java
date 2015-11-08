package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.processors.ValueTransformer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 10/10/15.
 */
public class TransformingValueExtractor<T> extends ValueExtractor {
    private List<ValueTransformer> outputValueTransformerList = new ArrayList<>();

    public TransformingValueExtractor(String outputMatchingRegex, Class<T> outputClasspath, ValueTransformer outputValueTransformer) {
        super(outputMatchingRegex, outputClasspath);

        outputValueTransformerList.add(outputValueTransformer);
    }

    @Override
    public Object getValue() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Object value = null;
        try {
            value = super.getValue();
        } catch(Exception ex) {
            // Something went wrong extracting the value.
            // Defaulting it to NULL and swallowing the exception
        }

        for (ValueTransformer transformer : outputValueTransformerList) {
            value = transformer.transformValue(value);
        }
        return value;
    }
}
