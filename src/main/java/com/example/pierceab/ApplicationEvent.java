package com.example.pierceab;

import com.example.pierceab.rest.ObjectSaverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicationEvent implements ApplicationListener<ApplicationReadyEvent> {

    ObjectSaverService objectSaverService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        URL options = ApplicationEvent.class.getClassLoader().getResource("options.csv");
        URL attributes = ApplicationEvent.class.getClassLoader().getResource("attributes.csv");

        if (attributes != null) {
            String attributesPath = attributes.getPath();
            try {
                objectSaverService.saveAttribute(attributesPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else log.info("Attributes file not found");

        if (options != null) {
            String optionsPath = options.getPath();
            try {
                objectSaverService.saveOption(optionsPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else log.info("Options file not found");
    }
}
