package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian on 8/29/15.
 */
public class PaginatedRecordParser<T> extends RecordParser<T> {
    private PaginatedValueExtractor recordValueExtractor;

    public PaginatedRecordParser(PaginatedValueExtractor recordValueExtractor, Map<String, ValueExtractor> recordValueExtractorMap, AbstractModelFactory<T> outputClassFactory) {
        super(recordValueExtractorMap, outputClassFactory);
        this.recordValueExtractor = recordValueExtractor;
    }

    public List<T> getRecordsAsList() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        List<String> allRecordsAsListOfStrings = findNextRecord();

        List<T> parsedAndPopulatedObjects = new ArrayList<>();
        for(String inputHtmlForSingleRecord : allRecordsAsListOfStrings) {
            setInputHtml(inputHtmlForSingleRecord);
            parsedAndPopulatedObjects.add(getRecord());
        }

        return parsedAndPopulatedObjects;
    }

    private List<String> findNextRecord() throws ClassNotFoundException {
        recordValueExtractor.setInputStringToSearch(inputHtml);
        return recordValueExtractor.getValuesAsList();
    }
}
