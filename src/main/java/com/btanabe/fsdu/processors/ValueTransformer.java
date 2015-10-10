package com.btanabe.fsdu.processors;

import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by brian on 9/23/15.
 */
public class ValueTransformer<TransformerClass, TransformationValueClass, OutputType> {
    private Class<TransformerClass> classWhichPerformsTheValueTransformation;
    private String transformingMethodName;
    private Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod;
    private TransformationValueClass inputValueToTheTransformationMethod;
    private OutputType defaultValueWhenNull;

    public ValueTransformer(Class<TransformerClass> classWhichPerformsTheValueTransformation, String transformingMethodName, Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod, TransformationValueClass inputValueToTheTransformationMethod, OutputType defaultValueWhenNull) {
        this.classWhichPerformsTheValueTransformation = classWhichPerformsTheValueTransformation;
        this.transformingMethodName = transformingMethodName;
        this.classTypeOfTheInputToTheTransformingMethod = classTypeOfTheInputToTheTransformingMethod;
        this.inputValueToTheTransformationMethod = inputValueToTheTransformationMethod;
        this.defaultValueWhenNull = defaultValueWhenNull;
    }

    public <InputClass> OutputType transformValue(InputClass inputValue) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(inputValueToTheTransformationMethod, inputValue);
    }
}
