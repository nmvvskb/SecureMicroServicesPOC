package com.taxilla.apigateway.configuration;

import lombok.SneakyThrows;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BrowserLauncher implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    @SneakyThrows
    public void onApplicationEvent(WebServerInitializedEvent event) {
        //TO-DO
    }
}
