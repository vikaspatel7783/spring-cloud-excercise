package com.vikas.springcloud.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${show.ticket.price:000}")
    private String showTicketPrice;

    @GetMapping("/ticket/current-price")
    public String printTicketCurrentPrice() {
        return showTicketPrice;
    }
}
