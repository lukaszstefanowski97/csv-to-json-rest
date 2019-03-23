package com.example.pierceab.rest;

import com.example.pierceab.fileUtils.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping
public class RestController {

    @GetMapping("/hello")
    public String helloPierce() {
        return "Hello Pierce!";
    }

    @GetMapping("/attributes")
    public String exposeAttributes() throws Exception {
        JsonParser.writeJsonToFile("data/attributes.csv", "data/attributes.json");
        return JsonParser.readJsonContent("data/attributes.json");
    }

    @GetMapping("/options")
    public String exposeOptions() throws Exception {
        JsonParser.writeJsonToFile("data/options.csv", "data/options.json");
        return JsonParser.readJsonContent("data/options.json");
    }

    @GetMapping("/merged")
    public String exposeMergedCSV() throws Exception {
        return JsonParser.parseMergedJson("data/attributes.csv", "data/options.csv",
                "data/attributes.json", "data/options.json");
    }
}
