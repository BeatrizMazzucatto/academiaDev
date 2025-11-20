package com.academiadev.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CsvExporter {
    public static <T> String export(List<T> items, List<String> columns) {
        if (items == null) items = new ArrayList<>();
        if (columns == null || columns.isEmpty()) {
            throw new IllegalArgumentException("At least one column must be provided");
        }

        StringBuilder builder = new StringBuilder();
        builder.append(String.join(",", columns)).append("\n");

        for (T item : items) {
            StringJoiner row = new StringJoiner(",");
            for (String col : columns) {
                row.add(escapeCsv(getProperty(item, col)));
            }
            builder.append(row).append("\n");
        }

        return builder.toString();
    }

    private static String getProperty(Object obj, String fieldName) {
        if (obj == null) return "";
        try {
            String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            Method m = obj.getClass().getMethod(methodName);
            Object value = m.invoke(obj);
            return value == null ? "" : String.valueOf(value);
        } catch (Exception e) {
            return "";
        }
    }

    private static String escapeCsv(String value) {
        if (value == null) return "";
        boolean mustQuote = value.contains(",") || value.contains("\n") || value.contains("\"");
        String escaped = value.replace("\"", "\"\"");
        if (mustQuote) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}


