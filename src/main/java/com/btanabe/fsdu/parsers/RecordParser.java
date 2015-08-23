package com.btanabe.fsdu.parsers;

import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

/**
 * Created by Brian on 7/28/15.
 */
public class RecordParser <T> {
    private String inputHtml;
    private Map<String, ValueExtractor> valueExtractorMap;
    private String outputClasspath;
    private FactoryBean<T> outputClassFactory;

    public RecordParser(String inputHtml, Map<String, ValueExtractor> valueExtractorMap, String outputClasspath, FactoryBean<T> outputClassFactory) {
        this.inputHtml = inputHtml;
        this.valueExtractorMap = valueExtractorMap;
        this.outputClasspath = outputClasspath;
        this.outputClassFactory = outputClassFactory;
    }

    public T parseRecord() {

        return null;
    }
}