package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser<T> {
    protected String inputHtml;
    private Map<String, ValueExtractor> valueExtractorMap;
    private AbstractModelFactory<T> outputClassFactory;

    public RecordParser(Map<String, ValueExtractor> valueExtractorMap, AbstractModelFactory<T> outputClassFactory) {
        this.valueExtractorMap = valueExtractorMap;
        this.outputClassFactory = outputClassFactory;
    }

    public void setInputHtml(String inputHtml) {
        this.inputHtml = inputHtml;
    }

    public T getRecord() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        valueExtractorMap.values().forEach(valueExtractor -> valueExtractor.setInputStringToSearch(inputHtml));
        outputClassFactory.setSetterMethodToValueMap(valueExtractorMap);
        return outputClassFactory.createObject();
    }
}