package com.hassaan.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hassaan.myfancypdfinvoices.ApplicationLauncher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {

    // @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // public UserService userService() {
    //     return new UserService();
    // }

    // public InvoiceService invoiceService(UserService userService, String cdnUrl) {
    //     return new InvoiceService(userService, cdnUrl);
    // }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
