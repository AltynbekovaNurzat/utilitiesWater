package kg.water.waterProject.service;

import kg.water.waterProject.model.JsonResponse;
import kg.water.waterProject.model.PaymentRequest;
import kg.water.waterProject.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAllPayments(String password);
    JsonResponse makePayment(PaymentRequest p);
    JsonResponse processPayment(Long paymentId);
    List<Payment> getAllPaymentsOfClient (Long clientId);
    List<Payment> getAllPaymByParams(String fio, String address, String status);
    boolean checkPassword(String password);
}
