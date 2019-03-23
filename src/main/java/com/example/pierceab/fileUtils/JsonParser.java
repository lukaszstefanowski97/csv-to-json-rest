package com.example.pierceab.fileUtils;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonParser {

    public static void writeJsonToFile(String inputPath, String outputPath) throws IOException {
        String command = "csvtojson " + inputPath;
        Process p = Runtime.getRuntime().exec(String.format(command));
        String s;
        String output = "";
        BufferedReader input = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        while ((s = input.readLine()) != null) {
            output = output + s;
        }

        writeString(output, outputPath, 0);
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

    public static String readJsonContent(String path) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static String parseMergedJson(String inputPath1, String inputPath2, String outputPath1,
                                         String outputPath2) throws JSONException, IOException {

        writeJsonToFile(inputPath1, outputPath1);
        writeJsonToFile(inputPath2, outputPath2);
        JSONObject json1 = new JSONObject(readJsonContent(outputPath1));
        JSONObject json2 = new JSONObject(readJsonContent(outputPath2));
        JSONArray merged = new JSONArray();
        merged.get(1);
        merged.put(json1);
        merged.put(json2);
        writeString(merged.toString(), "data/merged.json", 1);
        return merged.toString();
    }
}

