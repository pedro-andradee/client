package com.client.client.services;

import com.client.client.dto.ClientDTO;
import com.client.client.entitites.Client;
import com.client.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
       Page<Client> pages =  clientRepository.findAll(pageRequest);
       return pages.map(client -> new ClientDTO(client));
    }
}
