package com.btanabe.fsdu.models.factories;

import com.btanabe.fsdu.models.EspnProjectionModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Brian on 8/23/15.
 */
public class EspnProjectionModelFactory extends AbstractModelFactory {
    private Map<String, ValueExtractor> setterMethodToValueMap;

    @Override
    public void setSetterMethodToValueMap(Map setterMethodToValueMap) {
        this.setterMethodToValueMap = setterMethodToValueMap;
    }

    @Override
    public Object createObject() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        EspnProjectionModel model = new EspnProjectionModel();

        for (String setterMethodName : setterMethodToValueMap.keySet()) {
            Object value = setterMethodToValueMap.get(setterMethodName).getValue();
            Method setterMethod = ClassUtils.getMethod(EspnProjectionModel.class, setterMethodName, value.getClass());
            setterMethod.invoke(model, value);
        }

        return model;
    }

    @Override
    public Class<?> getObjectType() {
        return EspnProjectionModel.class;
    }

    @Override
    protected Object createInstance() throws Exception {
        return null;
    }
}
