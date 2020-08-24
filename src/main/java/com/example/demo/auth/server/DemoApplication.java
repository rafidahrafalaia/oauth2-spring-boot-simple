package com.example.demo.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Collections;

@SpringBootApplication
@EnableAuthorizationServer
public class DemoApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(8100);
	}
}
