package com.btanabe.fsdu.processors.transformers;

import java.util.ArrayList;

/**
 * Created by Brian on 11/28/15.
 */
public class CommaSeparatedStringFactory {

    public static String commaSeparateInputStrings(ArrayList<Object> unseparatedObjects) {
        StringBuilder commaSeparatedObjects = new StringBuilder();
        for(Object objectToCommaSeparate : unseparatedObjects) {
            commaSeparatedObjects.append(objectToCommaSeparate).append(",");
        }
        commaSeparatedObjects.deleteCharAt(commaSeparatedObjects.length() - 1);

        return commaSeparatedObjects.toString();
    }
}
