package com.vkstech.circuit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private RestTemplate template;

    @GetMapping("send")
    public String bookShow() {

        String emailServiceResponse = template.getForObject("http://localhost:8081/email/send", String.class);
        String paymentServiceResponse = template.getForObject("https://localhost:8082/payment/pay", String.class);

        return emailServiceResponse + "\n" + paymentServiceResponse;
    }
}
