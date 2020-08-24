package com.example.demo.auth.resources;

import com.example.demo.auth.server.DemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@EnableResourceServer
@RestController
public class ResourceServer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ResourceServer.class);
        app.run(args);
    }

    @GetMapping("/account")
    public String getAccount() {
        return "account 1";
    }

    @Bean
    public ResourceServerTokenServices tokenService() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("b");
        tokenServices.setClientSecret("b");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8100/oauth/check_token");
        return tokenServices;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(2222);
    }
}
