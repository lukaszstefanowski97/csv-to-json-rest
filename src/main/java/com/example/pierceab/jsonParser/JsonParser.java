package com.example.pierceab.jsonParser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.List;
import java.util.Map;

public class JsonParser {

    public static String parseJson(String inputPath, String outputPath) throws Exception {
        File input = new File(inputPath);
        File output = new File(outputPath);

        List<Map<?, ?>> data = readObjectsFromCsv(input);
        writeAsJson(data, output);
        return readFileAsString(outputPath);
    }

    public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

        return mappingIterator.readAll();
    }

    public static void writeAsJson(List<Map<?, ?>> data, File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, data);
    }

    public static String readFileAsString(String file) throws IOException {
        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine(); StringBuilder sb = new StringBuilder();
        while(line != null) {
            sb.append(line).append("\n"); line = buf.readLine();
        }
        String fileAsString = sb.toString();
        return fileAsString;
    }
}

