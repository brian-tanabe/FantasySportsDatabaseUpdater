package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.util.ClassUtils;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Brian on 8/23/15.
 */
public class ModelFactory<OutputClazz> extends AbstractModelFactory<OutputClazz> {
    private Class<OutputClazz> outputClazzClass;
    private Map<String, ValueExtractor> setterMethodToValueMap;

    @Override
    public void setSetterMethodToValueMap(Map setterMethodToValueMap) {
        this.setterMethodToValueMap = setterMethodToValueMap;
    }

    @Override
    public OutputClazz createObject() throws Exception {
        OutputClazz model = createInstance();
        setterMethodToValueMap.keySet().parallelStream().forEach(setterMethodName -> getValueAndStoreInModelUsingTheParameterizedSetterMethodName(model, setterMethodName));
        return model;
    }

    // TODO I KNOW THERE'S A MORE ELEGANT WAY TO HANDLE METHODS WHICH THROW EXCEPTIONS USED IN LAMBDA FUNCTIONS:
    @Deprecated
    private void getValueAndStoreInModelUsingTheParameterizedSetterMethodName(OutputClazz model, String setterMethodName) {
        try {
            Object value = setterMethodToValueMap.get(setterMethodName).getValue();
            ClassUtils.getMethod(outputClazzClass, setterMethodName, value.getClass()).invoke(model, value);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public OutputClazz apply(Map<String, Object> setterMethodNamesMappedToValues) {
        try {
            OutputClazz model = createInstance();
            Map<String, Object> synchronizedSetterMethodNamesMappedToValues = Collections.synchronizedMap(setterMethodNamesMappedToValues);
            synchronizedSetterMethodNamesMappedToValues.entrySet().parallelStream().forEach(setterMethodNameAndValue -> setValue(model, setterMethodNameAndValue.getKey(), setterMethodNameAndValue.getValue()));
            return model;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void setValue(OutputClazz model, String setterMethodName, Object value) {
        try {
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
    protected OutputClazz createInstance() throws Exception {
        return ClassUtils.getConstructorIfAvailable(outputClazzClass).newInstance();
    }

    @Deprecated
    @Override
    public void setOutputClazz(Class outputModelClass) {
        this.outputClazzClass = outputModelClass;
    }
}
