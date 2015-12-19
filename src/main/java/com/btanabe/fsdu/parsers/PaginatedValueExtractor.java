package com.btanabe.fsdu.parsers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 8/23/15.
 */
public class PaginatedValueExtractor<OutputClazz> extends ValueExtractor<OutputClazz> {
    public PaginatedValueExtractor(String outputMatchingRegex, Class<OutputClazz> outputClasspath) {
        super(outputMatchingRegex, outputClasspath);
    }

    public List<Object> getValuesAsList() throws Exception {
        List<Object> matchedObjects = new ArrayList<>();
        for (Object singleMatchedObject = getValue(); singleMatchedObject != null; singleMatchedObject = getValue()) {
            matchedObjects.add(singleMatchedObject);
        }

        return matchedObjects;
    }
}
