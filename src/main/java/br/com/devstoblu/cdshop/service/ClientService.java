package br.com.devstoblu.cdshop.service;

import br.com.devstoblu.cdshop.dto.ClientDTO;
import br.com.devstoblu.cdshop.mapper.ClientMapper;
import br.com.devstoblu.cdshop.model.Client;
import br.com.devstoblu.cdshop.repository.ClientRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; 

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clientMapper.entitiesToDTOs(clients);
    }

    public ClientDTO getClientById(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        return clientOptional.map(clientMapper::entityToDTO).orElse(null);
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.dtoToEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.entityToDTO(savedClient);
    }

    public ClientDTO updateClient(Long clientId, ClientDTO clientDTO) {
        Optional<Client> existingClientOptional = clientRepository.findById(clientId);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            // Update fields based on clientDTO
            existingClient.setName(clientDTO.getName());
            existingClient.setEmail(clientDTO.getEmail());

            Client updatedClient = clientRepository.save(existingClient);
            return clientMapper.entityToDTO(updatedClient);
        }
        return null;  // Handle the case where the client is not found
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
