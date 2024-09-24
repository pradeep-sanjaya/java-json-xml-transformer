package com.madmobile;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ticket")
public class TicketWrapper {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private String age;

    @JacksonXmlProperty(isAttribute = true)
    private String city;

    // Default constructor
    public TicketWrapper() {
    }

    // Constructor with parameters
    public TicketWrapper(String name, String age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}