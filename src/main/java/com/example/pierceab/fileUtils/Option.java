package com.example.pierceab.fileUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@Slf4j
public class Option {

    @Id
    @GeneratedValue
    Integer id;

    @JsonProperty("code")
    String code;

    @JsonProperty("label")
    @ElementCollection
    Map<String, String> labelMap = new HashMap<>();

    @JsonProperty("attribute")
    String attribute;

    @JsonProperty("sort_order")
    Integer sortOrder;

    @JsonBackReference
    @ManyToOne
    Attribute attributeReference;

    public Option(Map<String, String> jsonContent, Attribute attributeReferance) {
        this.id = id;
        this.attributeReference = attributeReferance;

        for (Map.Entry<String, String> record : jsonContent.entrySet()) {
            if (record.getKey().equals("code")) this.code = record.getValue();
            if (record.getKey().matches("label")) labelMap.put(record.getKey(), record.getValue());
            if (record.getKey().equals("attribute")) this.attribute = record.getValue();
            if (record.getKey().equals("sort_order")) this.sortOrder = Integer.valueOf(record.getValue());
        }
    }
}