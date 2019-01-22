package com.ataccama.homework.spring;

import com.ataccama.homework.persist.entity.ConnectionDetails;
import com.ataccama.homework.persist.service.ConnectionService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Roman Svoboda
 */
@Component
public class RoutingDataSource extends AbstractRoutingDataSource {


    @Autowired
    private ConnectionService connectionService;

    public RoutingDataSource(){

    }

    @PostConstruct
    public void init(){
        Map<Object, Object> targetDataSources = new HashMap<>();

        connectionService.findAll().stream().forEach(
                cd -> {
                    final HikariConfig hikariConfig = connectionDetailsToHikariConfig(cd);
                    HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
                    targetDataSources.put(cd.getName(), hikariDataSource);
                }
        );


        this.setTargetDataSources(targetDataSources);
        this.setDefaultTargetDataSource(targetDataSources.values().stream().findFirst().get());
    }

    private HikariConfig connectionDetailsToHikariConfig(ConnectionDetails cd) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(cd.getUsername());
        hikariConfig.setPassword(cd.getPassword());/*
        properties.setProperty("dataSource.serverName", cd.getHostname());
        properties.setProperty("dataSource.portNumber", String.valueOf(cd.getPort()));
        properties.setProperty("dataSource.databaseName", cd.getDatabaseName());*/
        hikariConfig.setJdbcUrl("jdbc:mysql://"+cd.getHostname()+":"+cd.getPort()+"/"+cd.getDatabaseName()/*+"?useSSL=false"*/ );
        return hikariConfig;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        HashMap templateVariables =
                (HashMap)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        return templateVariables.get("name");
    }
}
