package javatechy.codegen.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javatechy.codegen.controller.CodeGenController;
import javatechy.codegen.dto.Request;
import javatechy.codegen.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private Logger logger = Logger.getLogger(CodeGenController.class);
    private ClassLoader classLoader = getClass().getClassLoader();
    private String projectLocation = "/Users/deepak/Desktop";

    private final String APPLICATION_PROPS = "template/application.properties";

    @Override
    public void createProject(Request request) throws IOException {
        makeEmptyProject(request);
        makeApplicationProperty();
        makePomXml();
        addDependencies();
        addMainApplicaitonJava();
        addDatabaseProps();
        addDatabaseDto();
        addLogging();
        String fileName = getFileName(APPLICATION_PROPS);
        logger.info("fileName => " + fileName);
        String data = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        logger.info("Data => " + data);
    }

    private void makeEmptyProject(Request request) throws IOException {
        // TODO make empty project
        String artifactId = request.getArtifactId();
        String groupId = request.getGroupId();
        String name = request.getName();
        String description = request.getDescription();
        Path path = Paths.get((projectLocation + "." + artifactId + "." + groupId).replace(".", "/"));
        logger.info("File Location=> " + path.toString());
        Files.createDirectories(path);
    }

    private void addLogging() {
        // TODO logging
    }

    private void addDatabaseDto() {
        // TODO Auto-generated method stub
    }

    private void addDatabaseProps() {
        // TODO Database props
    }

    private void addMainApplicaitonJava() {
        // TODO // Application File
    }

    private void addDependencies() {
        // TODO add deps
    }

    private void makePomXml() {
        // TODO make pom.xml
    }

    private void makeApplicationProperty() {
        // TODO make application properties

    }

    private String getFileName(String APPLICATION_PROPS) {
        String fileName = classLoader.getResource(APPLICATION_PROPS)
            .getFile();
        return fileName;
    }
}
