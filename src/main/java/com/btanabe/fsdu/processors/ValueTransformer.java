package com.btanabe.fsdu.processors;

import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Function;

/**
 * Created by brian on 9/23/15.
 */
public class ValueTransformer<TransformerClass, TransformationValueClass, InputType, OutputType> implements Function<InputType, OutputType> {
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

    @Deprecated
    public <InputClass> OutputType transformValue(InputClass inputValue) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(objectTheTransformingMethodIsInvokedFrom, inputValue);
    }

    @Deprecated
    public <InputClass> OutputType transformValues(InputClass... inputValues) throws InvocationTargetException, IllegalAccessException {
        if (inputValues == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, createInputClassTypeArrayTheSameSizeAsTheNumberOfInputValues(inputValues)).invoke(objectTheTransformingMethodIsInvokedFrom, inputValues);
    }

    @Deprecated
    public <InputClass> OutputType transformValues(List<InputClass> inputValues) throws InvocationTargetException, IllegalAccessException {
        if (inputValues == null) {
            return defaultValueWhenNull;
        }

        return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, inputValues.getClass()).invoke(objectTheTransformingMethodIsInvokedFrom, inputValues);
    }

    private <InputClass> Class[] createInputClassTypeArrayTheSameSizeAsTheNumberOfInputValues(InputClass... inputValues) {
        Class[] inputParameterClassType = new Class[inputValues.length];
        for (int index = 0; index < inputValues.length; index++) {
            inputParameterClassType[index] = classTypeOfTheInputToTheTransformingMethod;
        }

        return inputParameterClassType;
    }

    @Override
    public OutputType apply(InputType inputValue) {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        try {
            return (OutputType) ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(objectTheTransformingMethodIsInvokedFrom, inputValue);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
