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
        setterMethodToValueMap.keySet().parallelStream().forEach(setterMethodName -> getValueAndStoreInModelUsingTheParameterizedSetterMethodName(model, setterMethodName));
        return model;
    }

    // TODO I KNOW THERE'S A MORE ELEGANT WAY TO HANDLE METHODS WHICH THROW EXCEPTIONS USED IN LAMBDA FUNCTIONS:
    private void getValueAndStoreInModelUsingTheParameterizedSetterMethodName(OutputClazz model, String setterMethodName) {
        try {
            Object value = setterMethodToValueMap.get(setterMethodName).getValue();
            ClassUtils.getMethod(outputClazzClass, setterMethodName, value.getClass()).invoke(model, value);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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
