package com.example.demo.Service;

import com.example.demo.Controller.PaymentController;
import com.example.demo.Helper.PaymentHelper;
import com.example.demo.Helper.ReservationHelper;
import com.example.demo.Models.Payment;
import com.example.demo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentController paymentController;

    private PaymentHelper paymentHelper;

    @Override
    public void createPayment(double amount, String hotel, String roomType, int roomNumber) {
        Payment payment = new Payment(amount,hotel,roomType,roomNumber);
        this.paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(int id) {
        this.paymentRepository.deleteById(id);

    }

    @Override
    public Payment getPayment(int id) {
        Optional<Payment> optionalPayment = this.paymentRepository.findById(id);
        return optionalPayment.get();
    }

    @Override
    public void createReservation(ReservationHelper reservationHelper) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ReservationHelper> request = new HttpEntity<ReservationHelper>(reservationHelper);

        String reservationServiceURL = "http://localhost:8008/api/reservation/create/reservation";
        ResponseEntity<ReservationHelper> responseEntity = restTemplate.postForEntity(reservationServiceURL,request,ReservationHelper.class);

    }

    public void setPaymentHelper(PaymentHelper paymentHelper){
        this.paymentHelper=paymentHelper;
    }
    public PaymentHelper getPaymentHelper(){
        return this.paymentHelper;
    }
}
