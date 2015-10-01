package com.btanabe.fsdu.processors;

import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by brian on 9/23/15.
 */
public class ValueTransformer<InputClass, OutputClass, TransformerClass, TransformationValueClass> {
    private Class<InputClass> inputClassType;
    private Class<OutputClass> outputClassType;
    private Class<TransformerClass> classWhichPerformsTheValueTransformation;
    private String transformingMethodName;
    private Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod;
    private TransformationValueClass inputValueToTheTransformationMethod;
    private OutputClass defaultValueWhenNull;


    public ValueTransformer(Class<InputClass> inputClassType, Class<OutputClass> outputClassType, Class<TransformerClass> classWhichPerformsTheValueTransformation, String transformingMethodName, Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod, TransformationValueClass inputValueToTheTransformationMethod, OutputClass defaultValueWhenNull) {
        this.inputClassType = inputClassType;
        this.outputClassType = outputClassType;
        this.classWhichPerformsTheValueTransformation = classWhichPerformsTheValueTransformation;
        this.transformingMethodName = transformingMethodName;
        this.classTypeOfTheInputToTheTransformingMethod = classTypeOfTheInputToTheTransformingMethod;
        this.inputValueToTheTransformationMethod = inputValueToTheTransformationMethod;
        this.defaultValueWhenNull = defaultValueWhenNull;
    }

    public OutputClass transformValue(InputClass inputValue) throws InvocationTargetException, IllegalAccessException {
        if (outputClassType.getClass().equals(Integer.class)) {
            System.out.println(String.format("isOutputInteger=[%d], defaultValueClass=[%s]", defaultValueWhenNull, defaultValueWhenNull.getClass().toString()));
        } else {
            System.out.println("I'M NOT AN INTEGER: " + outputClassType.getClass().getDeclaredClasses().toString());
        }

        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        return (OutputClass) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(inputValue, inputValueToTheTransformationMethod);
    }
}
