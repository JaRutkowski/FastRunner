package com.javafee.fr.filems.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.jfeesoft.fr.filems.model.domain")
public class PostgreSQLConfig {
}
