package kg.water.waterProject.repository;

import kg.water.waterProject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p join fetch p.client c where c.id=:clientId")
    List<Payment> getClientPayments(@Param("clientId") Long clientId);

    @Query("select p from Payment p join fetch p.client c " +
            "where c.fio like '%' +  coalesce(:fio, c.fio) + '%'" +
            "and c.address like '%' + coalesce(:address, c.address) + '%'" +
            "and p.status like '%' + coalesce(:status, p.status) + '%'" +
            "")
    List<Payment> getPaymentsByParam(@Param("fio") String fio,
                                     @Param("address") String address,
                                     @Param("status") String status);
}
