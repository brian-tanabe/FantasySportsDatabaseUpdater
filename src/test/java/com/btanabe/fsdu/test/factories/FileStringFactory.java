package com.btanabe.fsdu.test.factories;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.FactoryBean;

import java.io.File;

/**
 * Created by Brian on 7/28/15.
 */
public class FileStringFactory implements FactoryBean<String> {
    private File inputFile;

    @Override
    public String getObject() throws Exception {
        return FileUtils.readFileToString(inputFile);
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
