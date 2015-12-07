package com.btanabe.fsdu.parsers;


import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.util.Map;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser<T> {
    private Map<String, ValueExtractor> valueExtractorMap;
    private AbstractModelFactory<T> outputClassFactory;

    public RecordParser(Map<String, ValueExtractor> valueExtractorMap, AbstractModelFactory<T> outputClassFactory) {
        this.valueExtractorMap = valueExtractorMap;
        this.outputClassFactory = outputClassFactory;
    }

    public T getRecord(final String inputHtml) throws Exception {
        valueExtractorMap.values().forEach(valueExtractor -> valueExtractor.setInputStringToSearch(inputHtml));
        outputClassFactory.setSetterMethodToValueMap(valueExtractorMap);
        return outputClassFactory.createObject();
    }
}