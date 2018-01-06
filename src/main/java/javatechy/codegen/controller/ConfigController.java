package javatechy.codegen.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javatechy.codegen.service.SetupService;

@CrossOrigin(origins = "*")
@RestController
public class ConfigController {

    Logger logger = Logger.getLogger(ConfigController.class);

    @Autowired
    private SetupService setupService;

    @GetMapping(value = "/config")
    public String fetch(@RequestParam Map<String, String> paramMap) {
        setupService.postSetup();
        return "Config Updated";
    }
    
    @GetMapping(value = "/ping")
    public String health() {
        return "success";
    }
}
