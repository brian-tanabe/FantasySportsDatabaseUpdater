package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.processors.ValueTransformer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 10/10/15.
 */
public class TransformingValueExtractor<OutputClazz> extends ValueExtractor<OutputClazz> {
    private List<ValueTransformer> outputValueTransformerList = new ArrayList<>();

    public TransformingValueExtractor(String outputMatchingRegex, Class<OutputClazz> outputClasspath, ValueTransformer outputValueTransformer) {
        super(outputMatchingRegex, outputClasspath);

        outputValueTransformerList.add(outputValueTransformer);
    }

    // TODO CONSIDER HAVING THE ValueTransformer USE RETURN PARAMETERS.
    // TODO THAT WOULD LET ME USE LAMBDAS TO DO THE TRANSFORMATIONS
    @Override
    public OutputClazz apply(String inputStringToSearch) {
        OutputClazz value = null;

        try {
            value = super.apply(inputStringToSearch);
        } catch (Exception ex) {
            // Something went wrong extracting the value.
            // Defaulting it to NULL and swallowing the exception
        }

        for (ValueTransformer transformer : outputValueTransformerList) {
            value = (OutputClazz) transformer.apply(value);
        }
        return value;
    }

    @Deprecated
    public OutputClazz getValue() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        OutputClazz value = null;
        try {
            value = super.getValue();
        } catch (Exception ex) {
            // Something went wrong extracting the value.
            // Defaulting it to NULL and swallowing the exception
        }

        for (ValueTransformer transformer : outputValueTransformerList) {
            value = (OutputClazz) transformer.apply(value);
        }
        return value;
    }
}
