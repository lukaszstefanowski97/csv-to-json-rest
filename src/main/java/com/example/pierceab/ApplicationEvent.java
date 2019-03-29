package com.example.pierceab;

import com.example.pierceab.rest.ObjectSaverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

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

        if (options != null) {
            String optionsPath = options.getPath();
            objectSaverService.saveOption(optionsPath);
        } else log.info("Options file not found");

        if (attributes != null) {
            String attributesPath = attributes.getPath();
            objectSaverService.saveAttribute(attributesPath);
        } else log.info("Attributes file not found");
    }
}
