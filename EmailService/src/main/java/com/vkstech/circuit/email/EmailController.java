package com.vkstech.circuit.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @GetMapping("send")
    public String sendEmail() {
        return "Email Service called";
    }
}
