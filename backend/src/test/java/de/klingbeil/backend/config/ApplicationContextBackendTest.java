package de.klingbeil.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"de.klingbeil.backend.entity"})
public class ApplicationContextBackendTest {
}
