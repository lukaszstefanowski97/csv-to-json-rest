package com.example.pierceab.rest.impl;

import com.example.pierceab.fileUtils.Attribute;
import com.example.pierceab.fileUtils.Attributes;
import com.example.pierceab.fileUtils.Option;
import com.example.pierceab.fileUtils.Options;
import com.example.pierceab.rest.ObjectSaverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.stream.IntStream;

@Component
@Slf4j
public class ObjectSaverServiceImpl implements ObjectSaverService {

    private static Attributes attributes;
    private static Options options;

    @Override
    public List<Map<String, String>> csvContent(String filePath) throws IOException {
        LinkedList<Map<String, String>> csvContent = new LinkedList<>();
        LinkedList<String> labelList = new LinkedList<>();
        String[] rows;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while (true) {
            if (reader.readLine() == null) break;
            else {
                Map<String, String> labels = new HashMap<>();
                rows = StringEscapeUtils.unescapeHtml4("").split(";");
                if (labelList.size() == 0)  labelList.add(rows[0]);

                for (int index = 0; index < rows.length; index++) {
                    labels.put(labelList.get(index), rows[index].replaceAll("^\"|\"$", ""));
                }
                csvContent.add(labels);
            }
        }

        return csvContent;
    }

    @Override
    public void saveAttribute(String attributesPath) throws IOException {
        List<Map<String, String>> records = csvContent(attributesPath);
        List<Attribute> attributesList = new ArrayList<>();

        for (Map<String, String> record: records) {
            attributesList.add(new Attribute(record));
        }

        attributes.saveAll(attributesList);
    }

    @Override
    public void saveOption(String optionsPath) throws IOException {
        List<Map<String, String>> records = csvContent(optionsPath);
        List<Option> optionsList = new ArrayList<>();
        List<Attribute> attributesList = attributes.findAll();

        IntStream.range(0, optionsList.size()).forEach(index -> {
            if (attributesList.get(index) != null) {
                optionsList.add(new Option(records.get(index), attributesList.get(index)));
            } else optionsList.add(new Option(records.get(index), null));
        });
        options.saveAll(optionsList);
    }
}
