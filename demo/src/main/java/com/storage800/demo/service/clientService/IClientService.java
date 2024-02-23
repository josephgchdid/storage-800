package com.storage800.demo.service.clientService;

import com.storage800.demo.entity.client.dto.ClientDto;
import com.storage800.demo.entity.client.dto.EditClientDto;
import com.storage800.demo.entity.genericDto.IdDto;
import com.storage800.demo.error.NotFoundException;
import lombok.NonNull;

import java.util.List;

public interface IClientService {

    public IdDto CreateNewClient(@NonNull ClientDto clientDto);

    public ClientDto GetClientById(long id) throws NotFoundException;

    public List<ClientDto> GetAllClient();

    public void UpdateClient(long id,@NonNull EditClientDto editClientDto) throws NotFoundException;
}
