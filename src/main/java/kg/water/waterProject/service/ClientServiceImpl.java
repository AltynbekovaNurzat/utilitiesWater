package kg.water.waterProject.service;

import kg.water.waterProject.entity.Client;
import kg.water.waterProject.model.JsonResponse;
import kg.water.waterProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final String password = "admin";

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClients(String password) {
        List<Client> clients = null;
        if(checkPassword(password)) clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public JsonResponse addClient(Client client) {
        clientRepository.save(client);
        return new JsonResponse("New client is saved");
    }

    @Override
    public JsonResponse updateStatus(Long id) {
        Client client = clientRepository.findById(id).get();
        if (client != null){
            client.setActive(!client.getActive());
            clientRepository.save(client);
            return new JsonResponse("Status of client is updated, id: " + id);
        }
        return new JsonResponse("Client with id: " + id + " is not found");
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public BigDecimal getBalance(Long id) {
        return clientRepository.getBalance(id);
    }

    @Override
    public Client getClientByLchet(String lchet) {
        return clientRepository.getClientByLchet(lchet);
    }

    @Override
    public boolean checkPassword(String password) {
        if(password.equals(this.password)) return true;
        return false;
    }
}
