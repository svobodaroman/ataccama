package com.ataccama.homework.persist.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * @author Roman Svoboda
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "connection_detail")
public class ConnectionDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String hostname;
    private Integer port;
    private String databaseName;
    private String username;
    private String password;


    public ConnectionDetails(String name, String hostname, Integer port, String databaseName, String username, String password) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }
}
