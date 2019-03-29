package com.example.pierceab.fileUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class Option {

    @Id
    @GeneratedValue
    Integer id;

    @JsonProperty("code")
    String code;

    @JsonProperty("label")
    @OneToMany
    Map<String, String> labelMap = new HashMap<>();

    @JsonProperty("attribute")
    String attribute;

    @JsonProperty("sort_order")
    Integer sortOrder;

    @JsonBackReference
    @ManyToOne
    Attribute attributeReferance;

    public Option (Map<String, String> jsonContent, Attribute attributeReferance) {
        this.attributeReferance = attributeReferance;

        for (Map.Entry<String, String> record : jsonContent.entrySet()) {
            if (record.getKey().equals("code")) this.code = record.getValue();
            if (record.getKey().matches("label")) labelMap.put(record.getKey(), record.getValue());
            if (record.getKey().equals("attribute")) this.attribute = record.getValue();
            if (record.getKey().equals("sort_order")) this.sortOrder = Integer.valueOf(record.getValue());
        }
    }
}