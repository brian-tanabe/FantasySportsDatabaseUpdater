package com.btanabe.fsdu.parsers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 8/23/15.
 */
public class PaginatedValueExtractor<T> extends ValueExtractor<T> {

    public PaginatedValueExtractor(String outputMatchingRegex, Class<T> outputClasspath) {
        super(outputMatchingRegex, outputClasspath);
    }

    public List<Object> getValuesAsList() throws ClassNotFoundException {
        List<Object> matchedObjects = new ArrayList<>();
        for(Object singleMatchedObject = getValue(); singleMatchedObject != null; singleMatchedObject = getValue()) {
            matchedObjects.add(singleMatchedObject);
        }

        return matchedObjects;
    }
}
