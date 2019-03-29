package com.example.pierceab.rest;

import com.example.pierceab.fileUtils.Attribute;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    ObjectGetterService objectGetterService;

    @GetMapping("/mergedCSV")
    public LinkedList<Attribute> exposeMergedCSV() {
        return objectGetterService.getAttributes();
    }
}
