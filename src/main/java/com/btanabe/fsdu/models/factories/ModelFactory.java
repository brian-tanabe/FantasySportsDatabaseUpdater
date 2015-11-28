package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.util.ClassUtils;

import java.util.Map;

/**
 * Created by Brian on 8/23/15.
 */
public class ModelFactory<OutputClazz> extends AbstractModelFactory {
    private Class<OutputClazz> outputClazzClass;
    private Map<String, ValueExtractor> setterMethodToValueMap;

    @Override
    public void setSetterMethodToValueMap(Map setterMethodToValueMap) {
        this.setterMethodToValueMap = setterMethodToValueMap;
    }

    @Override
    public Object createObject() throws Exception {
        OutputClazz model = (OutputClazz) createInstance();

        for (String setterMethodName : setterMethodToValueMap.keySet()) {
            Object value = setterMethodToValueMap.get(setterMethodName).getValue();
            ClassUtils.getMethod(outputClazzClass, setterMethodName, value.getClass()).invoke(model, value);
        }

        return model;
    }

    @Override
    public Class<OutputClazz> getObjectType() {
        return outputClazzClass;
    }

    @Override
    protected Object createInstance() throws Exception {
        return ClassUtils.getConstructorIfAvailable(outputClazzClass).newInstance();
    }

    @Override
    public void setOutputClazz(Class outputModelClass) {
        this.outputClazzClass = outputModelClass;
    }
}
