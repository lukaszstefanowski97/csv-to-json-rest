package com.example.pierceab.rest;

import com.example.pierceab.jsonParser.JsonParser;
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
        return JsonParser.parseJson("data/attributes.csv", "data/attributes.json");
    }

    @GetMapping("/options")
    public String exposeOptions() throws Exception {
        return JsonParser.parseJson("data/options.csv", "data/options.json");
    }
}
