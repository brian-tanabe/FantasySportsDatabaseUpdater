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
    private String inputClassGetterMethodName;

    public ValueTransformer(Class<TransformerClass> classWhichPerformsTheValueTransformation, String transformingMethodName, Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod, TransformationValueClass inputValueToTheTransformationMethod, OutputType defaultValueWhenNull, String inputClassGetterMethodName) {
        this.classWhichPerformsTheValueTransformation = classWhichPerformsTheValueTransformation;
        this.transformingMethodName = transformingMethodName;
        this.classTypeOfTheInputToTheTransformingMethod = classTypeOfTheInputToTheTransformingMethod;
        this.inputValueToTheTransformationMethod = inputValueToTheTransformationMethod;
        this.defaultValueWhenNull = defaultValueWhenNull;
        this.inputClassGetterMethodName = inputClassGetterMethodName;
    }

    public <InputClass> OutputType transformValue(InputClass inputValue) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        System.out.println(inputValueToTheTransformationMethod.getClass().getName() + ": " + inputValueToTheTransformationMethod);
        System.out.println(inputValue.getClass().getName() + ": " + inputValue);

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(inputValue, inputValueToTheTransformationMethod);
    }
}
