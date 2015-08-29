package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.util.Map;

/**
 * Created by Brian on 8/29/15.
 */
public class PaginatedRecordParser<T> extends RecordParser<T> {

    public PaginatedRecordParser(String inputHtml, Map<String, ValueExtractor> valueExtractorMap, AbstractModelFactory<T> outputClassFactory) {
        super(inputHtml, valueExtractorMap, outputClassFactory);
    }
}
