package com.example.pierceab.fileUtils;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonParser {

    public static String readJsonContent(String path, Integer isItArray) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = contentBuilder.toString();
        if (isItArray == 1) result = result.substring(1, result.length()-2);
        return result;
    }

    private static void writeString(String output, String outputPath, Integer isItArray) {
        BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File(outputPath);
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            if (isItArray == 0) bufferedWriter.write(output.substring(1, output.length() - 1));
            else bufferedWriter.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (Exception ex) {

            }
        }
    }

    public static String parseMergedJson(String json1, String json2){
        String result = "[" + readJsonContent(json1, 1) + "," + readJsonContent(json2, 1) + "]";
        writeString(result, "data/merged.json",1);
        return result;
    }
}

