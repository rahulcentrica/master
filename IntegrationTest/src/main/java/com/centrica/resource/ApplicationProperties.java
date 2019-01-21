package com.centrica.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@ToString
public class ApplicationProperties {

	private String email;
	
}
