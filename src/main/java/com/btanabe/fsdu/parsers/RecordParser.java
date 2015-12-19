package com.btanabe.fsdu.parsers;


import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser<OutputClazz> implements Function<String, OutputClazz> {
    private Map<String, ValueExtractor> setterMethodNamesMappedToValueExtractors;
    private AbstractModelFactory<OutputClazz> outputClassFactory;

    public RecordParser(Map<String, ValueExtractor> valueExtractorMap, AbstractModelFactory<OutputClazz> outputClassFactory) {
        this.setterMethodNamesMappedToValueExtractors = Collections.synchronizedMap(valueExtractorMap);
        this.outputClassFactory = outputClassFactory;
    }

    @Override
    public OutputClazz apply(String inputHtml) {
        Map<String, Object> setterMethodNamesMappedToValues = Collections.synchronizedMap(new HashMap<>(setterMethodNamesMappedToValueExtractors.size()));
//        Map<String, Object> setterMethodNamesMappedToValues = new ConcurrentHashMap<>(setterMethodNamesMappedToValueExtractors.size());
        setterMethodNamesMappedToValueExtractors.entrySet().stream().forEach(setterMethodNameAndItsValueExtractor -> setterMethodNamesMappedToValues.put(setterMethodNameAndItsValueExtractor.getKey(), setterMethodNameAndItsValueExtractor.getValue().apply(inputHtml)));
        return outputClassFactory.apply(setterMethodNamesMappedToValues);
    }
}