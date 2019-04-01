package com.example.pierceab.rest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface ObjectSaverService {

    List<Map<String, String>> csvContent(String filePath) throws IOException;

    void saveAttribute(String attributesPath) throws IOException;

    void saveOption(String optionsPath) throws IOException;
}
