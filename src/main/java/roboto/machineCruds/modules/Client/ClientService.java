package roboto.machineCruds.modules.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roboto.machineCruds.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientEntity> list() {
        return clientRepository.findAll();
    }

    public ClientEntity getClientById(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client with ID " + id + " not found"));
    }

    public ClientEntity createClient(ClientDTO clientDTO) {
        return clientRepository.save(clientDTO.mapToEntity());
    }

    public ClientEntity update(ClientEntity oldClient, ClientDTO clientDTO) {
        oldClient.setName(clientDTO.getName());
        oldClient.setPrice(clientDTO.getPrice());
        return clientRepository.save(oldClient);
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
