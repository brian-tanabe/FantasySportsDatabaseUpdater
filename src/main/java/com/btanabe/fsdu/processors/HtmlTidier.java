package com.btanabe.fsdu.processors;

import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Brian on 8/22/15.
 */
public class HtmlTidier {
    private static Tidy htmlTidy = new Tidy();

    static {
        htmlTidy.setQuiet(true);
        htmlTidy.setShowWarnings(false);
        htmlTidy.setInputEncoding("UTF-8");
        htmlTidy.setOutputEncoding("UTF-8");
        htmlTidy.setXHTML(true);
        htmlTidy.setMakeClean(true);
        htmlTidy.setWrapSection(false);
    }

    public static String tidyHtmlAndConvertToXhtml(String dirtyHtml) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document xmlDocument = htmlTidy.parseDOM(new ByteArrayInputStream(dirtyHtml.getBytes()), outputStream);
        htmlTidy.pprint(xmlDocument, outputStream);
        return new String(outputStream.toByteArray());
    }
}
