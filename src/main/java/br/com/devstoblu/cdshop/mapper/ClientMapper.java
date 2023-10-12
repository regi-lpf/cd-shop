package br.com.devstoblu.cdshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.devstoblu.cdshop.dto.ClientDTO;
import br.com.devstoblu.cdshop.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);
    ClientDTO entityToDTO(Client client);
    List<ClientDTO> entitiesToDTOs(List<Client> clients);
    Client dtoToEntity(ClientDTO clientDTO);
}
