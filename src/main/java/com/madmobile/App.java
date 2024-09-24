package com.madmobile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class App {

    public static void main(String[] args) {
        try {
            // Step 1: Read JSON from a file
            ObjectMapper objectMapper = new ObjectMapper();

            // Load file from resources using the class loader
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream("input.json");
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! input.json");
            }
            //JsonNode jsonNode = objectMapper.readTree(new File("input.json"));
            JsonNode jsonNode = objectMapper.readTree(inputStream);

            // Step 2: Transform the JSON into the desired XML-ready structure
            TicketWrapper ticketWrapper = JsonToXmlTransformer.transformJsonNode(jsonNode);

            // Step 3: Convert the transformed object to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xmlContent = xmlMapper.writeValueAsString(ticketWrapper);

            // Step 4: Output the transformed XML
            System.out.println("Transformed XML:\n" + xmlContent);

            // Optionally, write the XML to a file
            xmlMapper.writeValue(new File("output.xml"), ticketWrapper);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
