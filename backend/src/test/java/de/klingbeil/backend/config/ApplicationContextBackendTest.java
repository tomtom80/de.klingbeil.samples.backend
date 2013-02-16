package de.klingbeil.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"de.klingbeil.backend"})
@ImportResource("classpath:applicationContext.xml")
public class ApplicationContextBackendTest {
}
