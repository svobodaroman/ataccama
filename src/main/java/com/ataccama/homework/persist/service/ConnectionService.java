package com.ataccama.homework.persist.service;

import com.ataccama.homework.persist.entity.ConnectionDetails;
import com.ataccama.homework.persist.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Roman Svoboda
 */
@Service
public class ConnectionService {

    private ConnectionsRepository connectionsRepository;

    @Autowired
    public ConnectionService(ConnectionsRepository connectionsRepository){
        this.connectionsRepository = connectionsRepository;
    }


    public List<ConnectionDetails> findAll() {
        return connectionsRepository.findAll();
    }
}
