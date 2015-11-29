package com.btanabe.fsdu.processors;

import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by brian on 9/23/15.
 */
public class ValueTransformer<TransformerClass, TransformationValueClass, OutputType> {
    private Class<TransformerClass> classWhichPerformsTheValueTransformation;
    private String transformingMethodName;
    private Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod;
    private TransformationValueClass objectTheTransformingMethodIsInvokedFrom;
    private OutputType defaultValueWhenNull;

    public ValueTransformer(Class<TransformerClass> classWhichPerformsTheValueTransformation, String transformingMethodName, Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod, TransformationValueClass objectTheTransformingMethodIsInvokedFrom, OutputType defaultValueWhenNull) {
        this.classWhichPerformsTheValueTransformation = classWhichPerformsTheValueTransformation;
        this.transformingMethodName = transformingMethodName;
        this.classTypeOfTheInputToTheTransformingMethod = classTypeOfTheInputToTheTransformingMethod;
        this.objectTheTransformingMethodIsInvokedFrom = objectTheTransformingMethodIsInvokedFrom;
        this.defaultValueWhenNull = defaultValueWhenNull;
    }

    public <InputClass> OutputType transformValue(InputClass inputValue) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(objectTheTransformingMethodIsInvokedFrom, inputValue);
    }

    public <InputClass> OutputType transformValues(List<InputClass> inputValues) throws InvocationTargetException, IllegalAccessException {
        if(inputValues == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, inputValues.getClass()).invoke(objectTheTransformingMethodIsInvokedFrom, inputValues);
    }
}
