package com.btanabe.fsdu.parsers;

import com.btanabe.fsdu.models.factories.AbstractModelFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Brian on 8/29/15.
 */
public class PaginatedRecordParser<OutputClazz> extends RecordParser<OutputClazz> {
    private PaginatedValueExtractor recordValueExtractor;

    public PaginatedRecordParser(PaginatedValueExtractor recordValueExtractor, Map<String, ValueExtractor> recordValueExtractorMap, AbstractModelFactory<OutputClazz> outputClassFactory) {
        super(recordValueExtractorMap, outputClassFactory);
        this.recordValueExtractor = recordValueExtractor;
    }

    public List<OutputClazz> getRecordsAsList(final String inputHtml) throws Exception {
        List<OutputClazz> parsedAndPopulatedObjects = getAllRecordsAsListOfStrings(inputHtml).stream().map((t) -> apply(t)).collect(Collectors.toList());

        return parsedAndPopulatedObjects;
    }

    private List<String> getAllRecordsAsListOfStrings(final String inputHtml) throws Exception {
        recordValueExtractor.setInputStringToSearch(inputHtml);
        return recordValueExtractor.getValuesAsList();
    }
}
