package kg.water.waterProject.service;

import kg.water.waterProject.entity.Status;
import kg.water.waterProject.model.JsonResponse;
import kg.water.waterProject.model.PaymentRequest;
import kg.water.waterProject.entity.Client;
import kg.water.waterProject.entity.Payment;
import kg.water.waterProject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final String password = "admin";

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public List<Payment> findAllPayments(String password) {
        List<Payment> payments = null;
        if(checkPassword(password)) payments = paymentRepository.findAll();
        return payments;
    }

    @Override
    public JsonResponse makePayment(PaymentRequest paymentRequest) {
        JsonResponse json_response = new JsonResponse();
        Client client = clientService.getClientByLchet(paymentRequest.getLchet());
        if(client == null){
            json_response.setMessage("User with the account " + paymentRequest.getLchet() + " doesn't exist");
        }
        else {
            Payment payment = new Payment(client, paymentRequest.getAmount());
            if(paymentRequest.getAmount().compareTo(BigDecimal.valueOf(50)) < 0) payment.setStatus(Status.ERROR);
            else payment.setStatus(Status.OK);
            paymentRepository.save(payment);
            json_response.setMessage("Payment has been saved");
        }
        return json_response;
    }

    @Override
    public JsonResponse processPayment(Long paymentId) {
        Payment p = paymentRepository.findById(paymentId).get();
        if(p != null){
            p.setStatus(Status.OK);
            paymentRepository.save(p);
            return new JsonResponse("Changed status for payment with id: " + paymentId);
        }

        return new JsonResponse("No payment found with id: " + paymentId);
    }

    @Override
    public List<Payment> getAllPaymentsOfClient(Long clientId) {
        return paymentRepository.getClientPayments(clientId);
    }

    @Override
    public List<Payment> getAllPaymByParams(String fio, String address, String status) {
        return paymentRepository.getPaymentsByParam(fio, address, status);
    }

    @Override
    public boolean checkPassword(String password) {
        if(password.equals(this.password)) return true;
        return false;
    }
}
