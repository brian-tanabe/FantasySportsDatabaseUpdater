package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.models.EspnProjectionModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

/**
 * Created by Brian on 8/23/15.
 */
public class EspnProjectionModelFactory implements FactoryBean<EspnProjectionModel> {
    private Map<String, ValueExtractor> valueExtractorMap;

    @Override
    public EspnProjectionModel getObject() throws Exception {
        return new EspnProjectionModel();
    }

    @Override
    public Class<?> getObjectType() {
        return EspnProjectionModel.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setMapContainingPopulatedValueExtractors(Map<String, ValueExtractor> valueExtractorMap) {
        this.valueExtractorMap = valueExtractorMap;
    }
}
