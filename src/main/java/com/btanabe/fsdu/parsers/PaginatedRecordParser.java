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

    public List<T> getRecordsAsList(final String inputHtml) throws Exception {
        List<T> parsedAndPopulatedObjects = new ArrayList<>();
        for(String inputHtmlForSingleRecord : getAllRecordsAsListOfStrings(inputHtml)) {
            parsedAndPopulatedObjects.add(getRecord(inputHtmlForSingleRecord));
        }

        return parsedAndPopulatedObjects;
    }

    private List<String> getAllRecordsAsListOfStrings(final String inputHtml) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        recordValueExtractor.setInputStringToSearch(inputHtml);
        return recordValueExtractor.getValuesAsList();
    }
}
