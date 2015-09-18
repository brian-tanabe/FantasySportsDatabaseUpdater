package com.btanabe.fsdu.web;

import com.btanabe.fsdu.processors.HtmlTidier;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Brian on 8/30/15.
 */
public class WebRequest {

    public String downloadWebPageSource(String url) throws IOException {
        return HtmlTidier.tidyHtmlAndConvertToXhtml(IOUtils.toString(new URL(url).openStream(), "utf-8"));
    }
}
