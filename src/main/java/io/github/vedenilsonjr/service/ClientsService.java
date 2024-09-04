package io.github.vedenilsonjr.service;

import io.github.vedenilsonjr.model.Client;
import io.github.vedenilsonjr.repository.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    private ClientsRepository repository;

    //  @Autowired Não precisa dessa anotação para injeção de dependencia pelo construtor
    public ClientsService ( ClientsRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Client client){
        ClientsRepository clientsRepository = new ClientsRepository();
        clientsRepository.persistir(client);
    }
}
