package com.btanabe.fsdu.parsers;

/**
 * Created by brian on 12/19/15.
 */
public class JsonValueExtractor<OutputClazz> extends ValueExtractor<String> {
    private String jsonKey;

    public JsonValueExtractor(String jsonObjectMatchingRegex) {
        super(jsonObjectMatchingRegex, String.class);
        this.jsonKey = jsonKey;
    }

}
