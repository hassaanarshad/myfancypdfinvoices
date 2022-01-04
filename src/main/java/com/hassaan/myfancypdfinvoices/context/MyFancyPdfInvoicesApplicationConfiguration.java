package com.hassaan.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hassaan.myfancypdfinvoices.ApplicationLauncher;
import com.hassaan.myfancypdfinvoices.service.InvoiceService;
import com.hassaan.myfancypdfinvoices.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
public class MyFancyPdfInvoicesApplicationConfiguration {

    // @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // public UserService userService() {
    //     return new UserService();
    // }

    // public InvoiceService invoiceService(UserService userService, String cdnUrl) {
    //     return new InvoiceService(userService, cdnUrl);
    // }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
