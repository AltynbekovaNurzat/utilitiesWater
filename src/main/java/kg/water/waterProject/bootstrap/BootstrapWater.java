package kg.water.waterProject.bootstrap;

import kg.water.waterProject.entity.Client;
import kg.water.waterProject.entity.Payment;
import kg.water.waterProject.entity.Status;
import kg.water.waterProject.repository.ClientRepository;
import kg.water.waterProject.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapWater implements CommandLineRunner {
    private ClientRepository clientRepository;
    private PaymentRepository paymentRepository;

    public BootstrapWater(ClientRepository clientRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Client c1 = new Client(10l,"11-222","NewClient","address",true);
        Client c2 = new Client(12l,"33-232","SecondClient","addres222",true);
        Payment p1 = new Payment(100l,c1, BigDecimal.ONE, Status.ERROR);
        Payment p2 = new Payment(200l,c2, BigDecimal.TEN,Status.ERROR);
        Payment p3 = new Payment(300l,c1, BigDecimal.TEN,Status.OK);
        Payment p4 = new Payment(400l,c2, BigDecimal.ONE,Status.OK);
        clientRepository.save(c1);
        clientRepository.save(c2);
        paymentRepository.save(p1);
        paymentRepository.save(p2);
        paymentRepository.save(p3);
        paymentRepository.save(p4);

    }
}
