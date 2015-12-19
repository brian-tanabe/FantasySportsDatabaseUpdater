package com.btanabe.fsdu.lambdas;

import org.springframework.util.ClassUtils;

import java.util.function.Function;

/**
 * Created by Brian on 12/12/15.
 */
public class LambdaValueTransformer<TransformerClass, TransformationValueClass, InputType, OutputType> implements Function<InputType, OutputType> {
    private Class<TransformerClass> classWhichPerformsTheValueTransformation;
    private String transformingMethodName;
    private Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod;
    private TransformationValueClass objectTheTransformingMethodIsInvokedFrom;
    private OutputType defaultValueWhenNull;

    public LambdaValueTransformer(Class<TransformerClass> classWhichPerformsTheValueTransformation, String transformingMethodName, Class<TransformationValueClass> classTypeOfTheInputToTheTransformingMethod, TransformationValueClass objectTheTransformingMethodIsInvokedFrom, OutputType defaultValueWhenNull) {
        this.classWhichPerformsTheValueTransformation = classWhichPerformsTheValueTransformation;
        this.transformingMethodName = transformingMethodName;
        this.classTypeOfTheInputToTheTransformingMethod = classTypeOfTheInputToTheTransformingMethod;
        this.objectTheTransformingMethodIsInvokedFrom = objectTheTransformingMethodIsInvokedFrom;
        this.defaultValueWhenNull = defaultValueWhenNull;
    }

    @Override
    public Object apply(Object inputValue) {
        if (inputValue == null) {
            return defaultValueWhenNull;
        }

        try {
            return ClassUtils.getMethod(classWhichPerformsTheValueTransformation, transformingMethodName, classTypeOfTheInputToTheTransformingMethod).invoke(objectTheTransformingMethodIsInvokedFrom, inputValue);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
