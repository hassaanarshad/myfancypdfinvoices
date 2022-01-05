package com.hassaan.myfancypdfinvoices.web;

import java.util.List;

import com.hassaan.myfancypdfinvoices.dto.InvoiceDto;
import com.hassaan.myfancypdfinvoices.model.Invoice;
import com.hassaan.myfancypdfinvoices.service.InvoiceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFancyPdfInvoicesController {

    private final InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    @GetMapping("/invoices")
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    // @PostMapping("/invoices")
    // public Invoice createInvoice(@RequestParam("user_id") String userId, @RequestParam Integer amount) {
    //     return invoiceService.create(userId, amount);
    // }

    // @PostMapping("/invoices/{userId}/{amount}")
    // public Invoice createInvoicePathVariables(@PathVariable String userId, @PathVariable Integer amount) {
    //     return invoiceService.create(userId, amount);
    // }

    @PostMapping("/invoices")
    public Invoice createInvoiceWithRequestBody(@RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
