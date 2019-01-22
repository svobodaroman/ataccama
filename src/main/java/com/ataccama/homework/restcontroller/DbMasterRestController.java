package com.ataccama.homework.restcontroller;

import com.ataccama.homework.persist.entity.ConnectionDetails;
import com.ataccama.homework.persist.repository.ClientDao;
import com.ataccama.homework.persist.repository.ConnectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Roman Svoboda
 */

@RestController
@RequestMapping("/connections")
public class DbMasterRestController {

    private ConnectionsRepository connectionsRepository;

    @Autowired
    public DbMasterRestController(ConnectionsRepository connectionsRepository) {
        this.connectionsRepository = connectionsRepository;
    }



    @GetMapping("/test")
    public List<ConnectionDetails> getDetails() {
        return connectionsRepository.findAll();
    }
}
