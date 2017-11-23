package com.example.nghia.cumback.expression;

import java.util.ArrayList;

/**
 * Created by nghia on 11/23/2017.
 */

public class ExpressionList {
    private static ArrayList<String> listExpressions = new ArrayList<>();

    private static String currentExpression = "";
    private static Integer currentIntVal;
    private static Double currentDoubleVal;

    public static void writeToExpression(String str) {
        currentExpression += str;
    }

    public static void writeToExpression(int str) {
        currentExpression += str;
    }

    public static String evaluate() {
        return null;
    }

    public static String getCurrentExpression() {
        return currentExpression;
    }
}
