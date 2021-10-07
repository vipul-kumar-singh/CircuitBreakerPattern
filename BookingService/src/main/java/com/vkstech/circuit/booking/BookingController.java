package com.vkstech.circuit.booking;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("booking")
@EnableHystrix
public class BookingController {

    @Autowired
    private RestTemplate template;

    @GetMapping("bookNow")
    @HystrixCommand(groupKey = "vkstech", commandKey = "vkstech", fallbackMethod = "bookShowFallback")
    public String bookShow() {

        String emailServiceResponse = template.getForObject("http://localhost:8082/email/send", String.class);
        String paymentServiceResponse = template.getForObject("http://localhost:8083/payment/pay", String.class);

        return emailServiceResponse + "\n" + paymentServiceResponse;
    }

    @GetMapping("bookNowWithoutHystrix")
    public String bookShowWithoutHystrix() {

        String emailServiceResponse = template.getForObject("http://localhost:8082/email/send", String.class);
        String paymentServiceResponse = template.getForObject("http://localhost:8083/payment/pay", String.class);

        return emailServiceResponse + "\n" + paymentServiceResponse;
    }

    public String bookShowFallback() {
        return "service gateway failed";
    }
}
