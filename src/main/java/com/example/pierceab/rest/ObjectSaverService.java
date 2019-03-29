package com.example.pierceab.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public interface ObjectSaverService {

    LinkedList<Map<String, String>> csvContent(String filePath) throws IOException;

    void saveAttribute(String attributesPath) throws IOException;

    void saveOption(String optionsPath) throws IOException;
}
