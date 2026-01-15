package com.citidev.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }

    public static <T> List<T> extractStandrdSFObjects(String json, Class<T> clazz) {
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode arrayNode = root.get("records");

            if (arrayNode == null || !arrayNode.isArray()) {
                return new ArrayList<>();
            }

            List<T> result = new ArrayList<>();
            Iterator<JsonNode> elements = arrayNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                result.add(mapper.treeToValue(node, clazz));
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract records ", e);
        }
    }
    
    public static <T> List<T> extractList(String json, String arrayField, Class<T> clazz) {
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode arrayNode = root.get(arrayField);

            if (arrayNode == null || !arrayNode.isArray()) {
                return new ArrayList<>();
            }

            List<T> result = new ArrayList<>();
            Iterator<JsonNode> elements = arrayNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                result.add(mapper.treeToValue(node, clazz));
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract list from field: " + arrayField, e);
        }
    }

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }


    public static <T> List<T> extractFlattenedList(String json, String recordKey, Class<T> clazz) {
        try {
            JsonNode root = mapper.readTree(json);
            JsonNode records = root.get(recordKey);
            if (records == null || !records.isArray()) return new ArrayList<>();

            List<T> result = new ArrayList<>();
            for (JsonNode record : records) {
                ObjectNode flat = mapper.createObjectNode();
                flattenDeep(record, "", flat);
                result.add(mapper.treeToValue(flat, clazz));
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse flattened JSON: " + e.getMessage(), e);
        }
    }

    /**
     * Recursively flattens JSON, diving through nested records arrays.
     */
    private static void flattenDeep(JsonNode node, String prefix, ObjectNode target) {
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String key = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
            JsonNode value = entry.getValue();

            if (value.isObject()) {
                // If object has a "records" array, drill into it
                JsonNode childRecords = value.get("records");
                if (childRecords != null && childRecords.isArray()) {
                    for (JsonNode child : childRecords) {
                        flattenDeep(child, key, target);
                    }
                } else {
                    // regular sub-object
                    flattenDeep(value, key, target);
                }
            } else if (value.isArray()) {
                // generic array (edge case)
                for (JsonNode item : value) {
                    flattenDeep(item, key, target);
                }
            } else {
                // scalar value
                target.set(key, value);
            }
        }
    }
    
    
    
}




//package com.citidev.utilities;
//
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.MapperFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//
//public class JsonUtils {
//    private static final ObjectMapper mapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);;
//
//    public static <T> T fromJson(String json, Class<T> clazz) {
//        try {
//            return mapper.readValue(json, clazz);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to parse JSON", e);
//        }
//    }
//    
//    
//    public static <T> List<T> extractList(String json, String arrayField, Class<T> clazz) {
//        try {
//            JsonNode root = mapper.readTree(json);
//            JsonNode arrayNode = root.get(arrayField);
//
//            if (arrayNode == null || !arrayNode.isArray()) {
//                return new ArrayList<>();
//            }
//
//            List<T> result = new ArrayList<>();
//            Iterator<JsonNode> elements = arrayNode.elements();
//            while (elements.hasNext()) {
//                JsonNode node = elements.next();
//                result.add(mapper.treeToValue(node, clazz));
//            }
//            return result;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to extract list from field: " + arrayField, e);
//        }
//    }
//    
//    public static String toJson(Object obj) {
//        try {
//            return mapper.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Failed to convert object to JSON", e);
//        }
//    }
//    
// 
//    public static <T> List<T> extractFlattenedList(String json, String recordKey, Class<T> clazz) {
//        try {
//            JsonNode root = mapper.readTree(json);
//            JsonNode records = root.get(recordKey);
//            if (records == null || !records.isArray()) return new ArrayList<>();
//
//            List<T> result = new ArrayList<>();
//            for (JsonNode record : records) {
//                ObjectNode flat = mapper.createObjectNode();
//                flattenJson(record, "", flat);
//                result.add(mapper.treeToValue(flat, clazz));
//            }
//
//            return result;
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to parse flattened JSON: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Recursively flattens nested JSON, except for child record arrays.
//     */
//    private static void flattenJson(JsonNode node, String prefix, ObjectNode target) {
//        node.fields().forEachRemaining(entry -> {
//            String key = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
//            JsonNode value = entry.getValue();
//
//            // --- handle nested child arrays (Invoices__r.records, etc.) ---
//            if (key.endsWith(".records") && value.isArray()) {
//                // keep array as-is, do not flatten
//                target.set(key, value);
//            }
//            // --- recursively flatten sub-objects ---
//            else if (value.isObject()) {
//                flattenJson(value, key, target);
//            }
//            // --- scalar or boolean fields ---
//            else {
//                target.set(key, value);
//            }
//        });
//    }
//
//}
