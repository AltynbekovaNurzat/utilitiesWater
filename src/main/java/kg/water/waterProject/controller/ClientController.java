package kg.water.waterProject.controller;

import kg.water.waterProject.entity.Client;
import kg.water.waterProject.model.JsonResponse;
import kg.water.waterProject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(ClientController.URLPAYMENT)
public class ClientController {
    public static final String URLPAYMENT = "/api/client";
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(@RequestHeader String password){
        return clientService.findAllClients(password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JsonResponse addClient(@RequestBody Client c){
        return clientService.addClient(c);
    }

    @PutMapping("status/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public JsonResponse changeStatus(@PathVariable Long id){
        return clientService.updateStatus(id);
    }

    @GetMapping("/balance/{id}")
    private BigDecimal getBalance(@PathVariable Long id){
        return clientService.getBalance(id);
    }

    @GetMapping("{id}")
    private Client getOneClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }

}
