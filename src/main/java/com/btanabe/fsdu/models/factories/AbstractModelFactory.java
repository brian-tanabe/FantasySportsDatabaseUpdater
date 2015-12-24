package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by Brian on 8/23/15.
 */
public abstract class AbstractModelFactory<OutputClazz> extends AbstractFactoryBean implements FactoryBean, Function<Map<String, Object>, OutputClazz> {

    public abstract void setOutputClazz(Class<OutputClazz> outputModelClass);

    public abstract void setSetterMethodToValueMap(Map<String, ValueExtractor> setterMethodToValueMap);

    public abstract OutputClazz createObject() throws Exception;
}
