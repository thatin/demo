package com.nanda.demo.spring.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@EnableJpaRepositories
@EnableCaching
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer customizeContainer() {
        return container -> {
            container.setContextPath("/demo/test");
            container.setPort(9090);
        };
    }

    @Bean
    public WebApplicationInitializer webApplicationInitializer() {
        return servletContext -> {
            TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
        };
    }
}
