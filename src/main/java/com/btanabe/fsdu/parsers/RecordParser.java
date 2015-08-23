package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.util.Map;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser <T> {
    private String inputHtml;
    private Map<String, ValueExtractor> valueExtractorMap;
    private Class<T> outputClass;
    private AbstractModelFactory<T> outputClassFactory;

    public RecordParser(String inputHtml, Map<String, ValueExtractor> valueExtractorMap, String outputClasspath, AbstractModelFactory<T> outputClassFactory) throws ClassNotFoundException {
        this.inputHtml = inputHtml;
        this.valueExtractorMap = valueExtractorMap;
        this.outputClass = (Class<T>) Class.forName(outputClasspath);
        this.outputClassFactory = outputClassFactory;
    }

    public T parseRecord() throws Exception {
        valueExtractorMap.values().forEach(valueExtractor -> valueExtractor.setInputHtmlString(inputHtml));
        outputClassFactory.setSetterMethodToValueMap(valueExtractorMap);
        return outputClassFactory.createObject();
    }
}