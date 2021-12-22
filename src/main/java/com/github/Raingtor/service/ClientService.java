package com.github.Raingtor.service;

import com.github.Raingtor.entity.Client;

import java.util.List;

public interface ClientService {
    Client findById(String id);

    List<Client> findAll();

    String create(Client client);

    void update(String id, Client client);

    void delete(String id);
}
