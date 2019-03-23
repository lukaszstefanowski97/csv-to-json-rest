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
    public String exposeAttributes() {
        return JsonParser.readJsonContent("data/attributes.json", 0);
    }

    @GetMapping("/options")
    public String exposeOptions() {
        return JsonParser.readJsonContent("data/options.json", 0);
    }

    @GetMapping("/merged")
    public String exposeMergedCSV() {
        return JsonParser.parseMergedJson("data/attributes.json", "data/options.json");
    }
}
