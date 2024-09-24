package com.madmobile;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonToXmlTransformer {

    public static TicketWrapper transformJsonNode(JsonNode jsonNode) {
        // Extract fields from JSON node
        String name = jsonNode.get("name").asText();
        String age = jsonNode.get("age").asText();
        String city = jsonNode.get("city").asText();

        // Create and return the TicketWrapper with the extracted values
        return new TicketWrapper(name, age, city);
    }
}
