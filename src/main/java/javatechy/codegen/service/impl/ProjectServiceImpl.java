package javatechy.codegen.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javatechy.codegen.controller.CodeGenController;
import javatechy.codegen.dto.Request;
import javatechy.codegen.service.ControllerGenService;
import javatechy.codegen.service.DatabaseService;
import javatechy.codegen.service.FileUtilService;
import javatechy.codegen.service.PomMakerService;
import javatechy.codegen.service.ProjectCreator;
import javatechy.codegen.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private Logger logger = Logger.getLogger(CodeGenController.class);
    public static final String projectLocation = "/Users/deepak/Desktop/project";
    public static final String pomLocation = "template/pom.xml";
    public static String applicationClassLocation = "template/DemoApplication.java";
    public static String controllerClassLocation = "template/TemplateController.java";
    public static final String srcMainJavaLoc = projectLocation + "/src/main/java";
    public static final String resourceLoc = projectLocation + "/src/main/resources";
    public static final String applicationProp = "template/application.properties";
    public static String applicationClassName;
    public static String javaCodeLoc;

    @Autowired
    private FileUtilService fileUtilService;

    @Autowired
    private ProjectCreator projectCreator;

    @Autowired
    private PomMakerService pomMakerService;

    @Autowired
    private DatabaseService datbaseService;

    @Autowired
    private ControllerGenService controllerGenService;

    /**
        addMainApplicaitonJava();
        addLogging();
     */
    @Override
    public void createProject(Request request) throws IOException {
        logger.info("== Creating empty project ==");

        projectCreator.initiliaze(request);
        projectCreator.generateEmptyProject(request);
        pomMakerService.createPomXml(request);
        projectCreator.generateMainClass(request);

        this.makeApplicationProperty();

        controllerGenService.generateControllers(request);

        pomMakerService.addDependencies(request);

        datbaseService.addDatabaseProps(request);
        datbaseService.addDatabaseDto(request);
    }

    private void makeApplicationProperty() throws IOException {
        String applicationPropData = fileUtilService.getDataFromClassLoader(applicationProp);
    }

}
