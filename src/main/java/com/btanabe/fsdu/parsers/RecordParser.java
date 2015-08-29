package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser<T> {
    private String inputHtml;
    private Map<String, ValueExtractor> valueExtractorMap;
    private AbstractModelFactory<T> outputClassFactory;

    public RecordParser(String inputHtml, Map<String, ValueExtractor> valueExtractorMap, AbstractModelFactory<T> outputClassFactory) {
        this.inputHtml = inputHtml;
        this.valueExtractorMap = valueExtractorMap;
        this.outputClassFactory = outputClassFactory;
    }

    public T parseRecord() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        valueExtractorMap.values().forEach(valueExtractor -> valueExtractor.setInputStringToSearch(inputHtml));
        outputClassFactory.setSetterMethodToValueMap(valueExtractorMap);
        return outputClassFactory.createObject();
    }
}