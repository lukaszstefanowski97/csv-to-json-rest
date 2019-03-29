package com.example.pierceab.fileUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@Slf4j
public class Attribute {

    @Id
    @GeneratedValue
    Integer id;

    @JsonProperty("code")
    String code;

    @JsonProperty("label")
    @OneToMany
    Map<String, String> labelMap = new HashMap<>();

    @JsonManagedReference
    @OneToMany
    LinkedList<Option> optionList;

    public Attribute(Map<String, String> jsonContent) {
        for (Map.Entry<String, String> record: jsonContent.entrySet()) {
            if (record.getKey().equals("code")) this.code = record.getValue();
            if (record.getKey().matches("label")) labelMap.put(record.getKey(), record.getValue());
        }
    }
}
