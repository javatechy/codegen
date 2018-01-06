package javatechy.codegen.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javatechy.codegen.controller.CodeGenController;
import javatechy.codegen.dto.Request;
import javatechy.codegen.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {


    private Logger logger = Logger.getLogger(CodeGenController.class);


    @Override
    public void createProject(Request request) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("application.properties")), StandardCharsets.UTF_8);
        logger.info("Data => "+ data);
    }
}
