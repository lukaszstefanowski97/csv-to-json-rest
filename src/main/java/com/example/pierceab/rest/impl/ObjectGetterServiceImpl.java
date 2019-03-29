package com.example.pierceab.rest.impl;

import com.example.pierceab.fileUtils.Attribute;
import com.example.pierceab.fileUtils.Attributes;
import com.example.pierceab.rest.ObjectGetterService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ObjectGetterServiceImpl implements ObjectGetterService {

    Attributes attributes;

    public LinkedList<Attribute> getAttributes() {
        return (LinkedList<Attribute>) attributes.findAll();
    }
}
