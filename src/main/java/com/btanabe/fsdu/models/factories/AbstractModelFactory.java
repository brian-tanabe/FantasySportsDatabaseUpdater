package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Brian on 8/23/15.
 */
public abstract class AbstractModelFactory<OutputClazz> extends AbstractFactoryBean implements FactoryBean {

    public abstract void setOutputClazz(Class<OutputClazz> outputModelClass);
    public abstract void setSetterMethodToValueMap(Map<String, ValueExtractor> setterMethodToValueMap);
    public abstract OutputClazz createObject() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, Exception;
}
