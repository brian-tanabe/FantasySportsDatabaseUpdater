package com.btanabe.fsdu.test.factories;

import com.btanabe.fsdu.processors.HtmlTidier;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.FactoryBean;

import java.io.File;

/**
 * Created by Brian on 8/22/15.
 */
public class FileTidiedStringFactory implements FactoryBean<String> {
    private File inputFile;

    @Override
    public String getObject() throws Exception {
        return HtmlTidier.tidyHtmlAndConvertToXhtml(FileUtils.readFileToString(inputFile));
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }
}
