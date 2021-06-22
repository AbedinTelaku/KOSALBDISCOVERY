package com.example.demo.Controller;

import com.example.demo.Entity.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CheckOutController {

    //@Value("${stripe_public_key}")
    private String stripePublicKey="pk_test_51J59QBBGVeEfRZf72R7Puxe9772bDmnGRpinGgr6ZEzlbOECxJsMO5BYVLZC5IcC400OEDd0gD4vJ0uwAjwgCsF500gq1lKYYn";

    @RequestMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }

}
