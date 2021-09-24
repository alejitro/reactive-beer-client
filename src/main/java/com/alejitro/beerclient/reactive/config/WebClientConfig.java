package com.alejitro.beerclient.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import static com.alejitro.beerclient.reactive.config.WebClientProperties.BASE_URL;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        ClientHttpConnector httpConnector = new ReactorClientHttpConnector();
        return WebClient.builder().clientConnector(httpConnector).baseUrl(BASE_URL).build();
    }
}
