package com.example.pierceab.rest;

import java.util.LinkedList;
import java.util.Map;

public interface ObjectSaverService {

    LinkedList<Map<String, String>> csvContent(String file);

    void saveAttribute(String attributesPath);

    void saveOption(String optionsPath);
}
