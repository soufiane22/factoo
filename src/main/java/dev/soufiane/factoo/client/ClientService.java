package dev.soufiane.factoo.client;

import dev.soufiane.factoo.common.exception.InvalidStateException;
import dev.soufiane.factoo.common.exception.ResourceNotFoundException;
import java.util.UUID;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public  Optional<List<Client> > getAllClients(){
        return Optional.of(clientRepository.findAll());
    }

    public Optional<Client> getClientById(UUID id){
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(UUID id, Client request) {
        if (clientRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new InvalidStateException("Cet email est déjà utilisé par un autre client");
        }
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client introuvable avec l'id " + id
                ));
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setIce(request.getIce());
        client.setPhone(request.getPhone());
        return  clientRepository.save(client);
    }

    public void deleteClient(UUID id) {
        clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client introuvable avec l'id " + id
                ));
        clientRepository.deleteById(id);
    }
}
