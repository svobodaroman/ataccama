package com.ataccama.homework.restcontroller;

import com.ataccama.homework.hibernate.MetadataExtractorIntegrator;
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
@RequestMapping("/browser")
public class DbBrowserRestController {


    private ClientDao clientDao;

    @Autowired
    public DbBrowserRestController(ClientDao clientDao) {

        this.clientDao = clientDao;
    }

    @GetMapping(value = "/schemas",
            produces = "application/json")
    public String listSchemas(){
        return null;
    }

    @GetMapping(value = "/{schema}/tables",
            produces = "application/json")
    public String listTables(@PathVariable("schema") String schema){
        return schema;
    }

    @GetMapping(value = "/{schema}/{table}/columns",
            produces = "application/json")
    public String listColumns(@PathVariable("schema") String schema, @PathVariable("table") String table){
        return null;
    }

    @GetMapping(value = "/{schema}/{table}/preview-data",
            produces = "application/json")
    public String previewData(@PathVariable("schema") String schema, @PathVariable("table") String table){
        return null;
    }

}
