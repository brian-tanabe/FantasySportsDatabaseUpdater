package com.btanabe.fsdu.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 12/12/15.
 */
public class LambdaTransformingValueExtractor<OutputClazz> extends LambdaValueExtractor<OutputClazz> {
    private List<LambdaValueTransformer> outputValueTransformerList = new ArrayList<>();

    public LambdaTransformingValueExtractor(String outputMatchingRegex, Class outputClasspath, LambdaValueTransformer valueTransformer) {
        super(outputMatchingRegex, outputClasspath);

        outputValueTransformerList.add(valueTransformer);
    }

    @Override
    public OutputClazz apply(String inputStringToSearch) {
        OutputClazz extractedValue = super.apply(inputStringToSearch);
        for (LambdaValueTransformer valueTransformer : outputValueTransformerList) {
            extractedValue = (OutputClazz) valueTransformer.apply(extractedValue);
        }

        return extractedValue;
    }
}
