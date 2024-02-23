package com.storage800.demo.service.clientService;

import com.storage800.demo.entity.client.Client;
import com.storage800.demo.entity.client.dto.ClientDto;
import com.storage800.demo.entity.client.dto.EditClientDto;
import com.storage800.demo.entity.genericDto.IdDto;
import com.storage800.demo.error.NotFoundException;
import com.storage800.demo.repository.clientRepository.ClientRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public IdDto CreateNewClient(@NonNull ClientDto clientDto)
    {
        Client newClient = new Client(0,new Date() ,clientDto.getName(), clientDto.getLastName(), clientDto.getNumber());

        long newId = repository.save(newClient).getId();

        return  new IdDto(newId);
    }

    public ClientDto GetClientById(long id) throws NotFoundException {

        Optional<Client> foundClient = repository.findById(id);

        if(foundClient.isEmpty())
        {
            throw new NotFoundException("Client not found");
        }

        return modelMapper.map(foundClient.get(), ClientDto.class);
    }

    public List<ClientDto> GetAllClient()
    {
        var clients = repository.findAll();

        return modelMapper.map(clients, new TypeToken<List<ClientDto>>(){}.getType());
    }

    public void UpdateClient(long id,@NonNull EditClientDto editClientDto) throws NotFoundException {
        Optional<Client> foundClient = repository.findById(id);

        if(foundClient.isEmpty())
        {
            throw new NotFoundException("Client not found");
        }

        Client clientToUpdate = foundClient.get();

        Client mappedExternalPart =  modelMapper.map(editClientDto, Client.class);

        modelMapper.map(mappedExternalPart, clientToUpdate);

        repository.save(clientToUpdate);
    }
}
