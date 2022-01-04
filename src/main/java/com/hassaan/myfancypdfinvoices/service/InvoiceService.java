package com.hassaan.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.hassaan.myfancypdfinvoices.model.Invoice;
import com.hassaan.myfancypdfinvoices.model.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();

    private final UserService userService;
    private final String cdnUrl;

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, cdnUrl + "/images/default/sample.pdf", amount);
        invoices.add(invoice);

        return invoice;
    }
}
