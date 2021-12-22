package com.github.Raingtor.service.impl;

import com.github.Raingtor.controller.exception.ObjectNotFoundException;
import com.github.Raingtor.entity.Client;
import com.github.Raingtor.repository.ClientRepository;
import com.github.Raingtor.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor_ = @Autowired)
@NoArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    public Client findById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Client.class.getSimpleName(), id));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public String create(Client client) {
        return clientRepository.saveAndFlush(client).getId();
    }

    public void update(String id, Client client) {
        if (findById(id) != null) {
            client.setId(id);
            clientRepository.saveAndFlush(client);
        } else {
            throw new ObjectNotFoundException(Client.class.getSimpleName(), id);
        }
    }

    public void delete(String id) {
        if (findById(id) != null) {
            clientRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Client.class.getSimpleName(), id);
        }
    }
}
