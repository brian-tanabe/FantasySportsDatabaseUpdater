package com.btanabe.fsdu.collectors;

import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import com.btanabe.fsdu.parsers.ValueExtractor;
import com.btanabe.fsdu.web.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 10/11/15.
 */
public class RecordCollector<OutputType> {
    private ValueExtractor<String> nextPageLinkExtractor;
    private PaginatedRecordParser<OutputType> recordParser;
    private WebRequest webRequest;

    public RecordCollector(ValueExtractor<String> nextPageLinkExtractor, PaginatedRecordParser<OutputType> recordParser) {
        this.nextPageLinkExtractor = nextPageLinkExtractor;
        this.recordParser = recordParser;
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
}
