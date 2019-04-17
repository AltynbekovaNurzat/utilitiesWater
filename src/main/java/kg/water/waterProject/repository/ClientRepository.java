package kg.water.waterProject.repository;

import kg.water.waterProject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select sum(p.amount) from Payment p inner join p.client c " +
            "where c.id = :clientId and p.status = 0")
    BigDecimal getBalance(@Param("clientId") Long clientId);

    @Query("select c from Client c where c.lchet = :lchet")
    Client getClientByLchet(@Param("lchet") String lchet);
}
