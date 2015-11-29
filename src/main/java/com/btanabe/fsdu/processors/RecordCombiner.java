package com.btanabe.fsdu.processors;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Brian on 11/27/15.
 */
public class RecordCombiner<OutputClazz> {
    private final Class<OutputClazz> outputClazzClass;
    private String primaryRecordIdentifierGetterMethodName;
    private Object primaryRecordIdentifierMatchingValue;
    private String childRecordIdentifyingGetterMethodName;

    private Map<Pair<String, String>, ValueTransformer> valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName;

    private List<OutputClazz> uncombinedRecordList;

    public RecordCombiner(Class<OutputClazz> outputClassType, String recordKeyGetterMethodName, Object primaryRecordIdentifierMatchingValue, String childRecordIdentifyingGetterMethodName, Map<Pair<String, String>, ValueTransformer> valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName) {
        this.outputClazzClass = outputClassType;
        this.primaryRecordIdentifierGetterMethodName = recordKeyGetterMethodName;
        this.primaryRecordIdentifierMatchingValue = primaryRecordIdentifierMatchingValue;
        this.childRecordIdentifyingGetterMethodName = childRecordIdentifyingGetterMethodName;
        this.valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName = valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName;
    }

    public void setUncombinedRecordList(List<OutputClazz> uncombinedRecordList) {
        this.uncombinedRecordList = uncombinedRecordList;
    }

    public List<OutputClazz> combineRecords() throws InvocationTargetException, IllegalAccessException {
        List<OutputClazz> combinedRecords = new ArrayList<>();
        for (OutputClazz individualRecord : uncombinedRecordList) {
            if (ClassUtils.getMethod(outputClazzClass, primaryRecordIdentifierGetterMethodName).invoke(individualRecord).equals(primaryRecordIdentifierMatchingValue)) {
                List<OutputClazz> childRecords = findRecordsToCombineWithTheParameterizedRecord(individualRecord);
                combinedRecords.add(combineRecords(individualRecord, childRecords));
            } else {
                combinedRecords.add(individualRecord);
            }
        }

        return combinedRecords;
    }

    private List<OutputClazz> findRecordsToCombineWithTheParameterizedRecord(OutputClazz parentRecord) throws InvocationTargetException, IllegalAccessException {
        final Object childRecordIdentifyingValueFromParentRecord = getValueFromObject(childRecordIdentifyingGetterMethodName, parentRecord);
        List<OutputClazz> parentAndMatchingChildrenRecordList = uncombinedRecordList.parallelStream().filter(possibleMatch -> getValueFromObject(childRecordIdentifyingGetterMethodName, possibleMatch).equals(childRecordIdentifyingValueFromParentRecord)).collect(Collectors.toList());
        parentAndMatchingChildrenRecordList.remove(parentRecord);
        return parentAndMatchingChildrenRecordList;
    }

    private OutputClazz combineRecords(OutputClazz parentRecord, List<OutputClazz> childRecords) throws InvocationTargetException, IllegalAccessException {
        for (Pair<String, String> getterAndSetterMethodNamePair : valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName.keySet()) {
            List<Object> combinedArguments = childRecords.stream().map(childRecord -> getValueFromObject(getterAndSetterMethodNamePair.getLeft(), childRecord)).collect(Collectors.toList());

            Object combinedValue = valueCombinerWorkerMappedToChildRecordGetterMethodAndParentRecordSetterMethodName.get(getterAndSetterMethodNamePair).transformValues(combinedArguments);
            setObjectsValue(getterAndSetterMethodNamePair.getRight(), combinedValue, parentRecord);
        }


        return parentRecord;
    }

    private Object getValueFromObject(String getterMethodName, OutputClazz outputClazzObject) {
        try {
            return ClassUtils.getMethod(outputClazzClass, getterMethodName).invoke(outputClazzObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void setObjectsValue(String setterMethodName, Object value, OutputClazz outputClazzObjectReturnParameter) {
        try {
            ClassUtils.getMethod(outputClazzClass, setterMethodName, value.getClass()).invoke(outputClazzObjectReturnParameter, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
