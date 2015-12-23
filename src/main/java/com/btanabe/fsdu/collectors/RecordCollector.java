package com.btanabe.fsdu.collectors;

import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import com.btanabe.fsdu.parsers.ValueExtractor;
import com.btanabe.fsdu.web.WebRequest;
import org.apache.commons.lang3.reflect.ConstructorUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by Brian on 10/11/15.
 */
public class RecordCollector<OutputType, OutputContainerType extends Collection> implements BiFunction<String, WebRequest, OutputContainerType> {
    private Class<OutputContainerType> outputContainerClazz;
    private ValueExtractor<String> nextPageLinkExtractor;
    private PaginatedRecordParser<OutputType> recordParser;
    private WebRequest webRequest;

    public RecordCollector(ValueExtractor<String> nextPageLinkExtractor, PaginatedRecordParser<OutputType> recordParser) {
        this.nextPageLinkExtractor = nextPageLinkExtractor;
        this.recordParser = recordParser;
    }

    public RecordCollector(ValueExtractor<String> nextPageLinkExtractor, PaginatedRecordParser<OutputType> recordParser, Class<OutputContainerType> outputContainerClazz) {
        this.nextPageLinkExtractor = nextPageLinkExtractor;
        this.recordParser = recordParser;
        this.outputContainerClazz = outputContainerClazz;
    }

    public List<OutputType> getAllRecordsAsList(String seedWebPageToScrape) throws Exception {
        List<OutputType> collectedRecordList = new ArrayList<>();

        String nextPageUrl = seedWebPageToScrape;
        do {
            String pageHtml = webRequest.downloadWebPageSource(nextPageUrl);
            collectedRecordList.addAll(recordParser.getRecordsAsList(pageHtml));
            nextPageUrl = nextPageLinkExtractor.apply(pageHtml);
        } while (nextPageUrl != null && !nextPageUrl.isEmpty());

        return collectedRecordList;
    }

    public void setWebRequest(WebRequest webRequest) {
        this.webRequest = webRequest;
    }

    @Override
    public OutputContainerType apply(String seedWebPageToScrape, WebRequest webRequest) {
        try {
            OutputContainerType outputCollection = ConstructorUtils.getAccessibleConstructor(outputContainerClazz).newInstance();
            String nextPageUrl = seedWebPageToScrape;
            do {
                String pageHtml = webRequest.downloadWebPageSource(nextPageUrl);
                outputCollection.addAll(recordParser.getRecordsAsList(pageHtml));
                nextPageUrl = nextPageLinkExtractor.apply(pageHtml);
            } while (nextPageUrl != null && !nextPageUrl.isEmpty());

            return outputCollection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
