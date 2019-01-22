package com.ataccama.homework.persist.repository;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author Roman Svoboda
 */

@Service
public class ClientDao {
    public ClientDao(DataSource clientDatasource) {

    }
}
