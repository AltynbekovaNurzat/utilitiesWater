package kg.water.waterProject.service;

import kg.water.waterProject.entity.Client;
import kg.water.waterProject.model.JsonResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ClientService {
    List<Client> findAllClients(String password);
    JsonResponse addClient(Client client);
    JsonResponse updateStatus(Long id);
    BigDecimal getBalance(Long id);
    Client getClientById(Long id);
    Client getClientByLchet(String lchet);
    boolean checkPassword(String password);
}
