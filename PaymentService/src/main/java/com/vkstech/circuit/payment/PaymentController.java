package com.vkstech.circuit.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @GetMapping("pay")
    public String paymentProcess() {
        return "Payment Service called";
    }
}
