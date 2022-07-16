package com.jfeesoft.fr.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.jfeesoft.fr.model.domain")
public class PostgreSQLConfig {
}
