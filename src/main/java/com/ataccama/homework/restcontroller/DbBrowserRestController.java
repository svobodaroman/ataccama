package com.ataccama.homework.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roman Svoboda
 */

@RestController
@RequestMapping("/browser")
public class DbBrowserRestController {

    @GetMapping(value = "/schemas",
            produces = "application/json")
    public String listSchemas(){
        return null;
    }

    @GetMapping(value = "/{schema}/tables",
            produces = "application/json")
    public String listTables(@PathVariable("schema") String schema){
        return null;
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
