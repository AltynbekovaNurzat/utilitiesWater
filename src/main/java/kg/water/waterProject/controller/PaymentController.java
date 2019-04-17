package kg.water.waterProject.controller;

import kg.water.waterProject.entity.Payment;
import kg.water.waterProject.model.JsonResponse;
import kg.water.waterProject.model.PaymentRequest;
import kg.water.waterProject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentController.URLPAYMENT)
public class PaymentController {
    public static final String URLPAYMENT = "/api/payment";

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getPayments(@RequestHeader String password){
        return paymentService.findAllPayments(password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JsonResponse addPayment(@RequestBody PaymentRequest p){
        return paymentService.makePayment(p);
    }

    @GetMapping("/{clientId}")
    public List<Payment> getAllPaymentsOfClient(@PathVariable Long clientId){
        return paymentService.getAllPaymentsOfClient(clientId);
    }

    @PutMapping("/confirm/{id}")
    public JsonResponse confirmPayment(@PathVariable Long id){
        return paymentService.processPayment(id);
    }

    @GetMapping
            (params = {"fio", "address", "status"}, value = "/search")
    public List<Payment> getPaymentsByParams(
            @RequestParam(value = "fio", required = false)String fio,
            @RequestParam(value = "address", required = false)String address,
            @RequestParam(value = "status", required = false)String status
    ){
        return paymentService.getAllPaymByParams(fio, address, status);
    }

}
