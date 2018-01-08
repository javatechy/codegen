package javatechy.codegen.service.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javatechy.codegen.common.Common;
import javatechy.codegen.common.JacksonParser;
import javatechy.codegen.controller.CodeGenController;
import javatechy.codegen.dto.Properties;
import javatechy.codegen.dto.Request;
import javatechy.codegen.service.FileUtilService;
import javatechy.codegen.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private Logger logger = Logger.getLogger(CodeGenController.class);
    public static final String projectLocation = "/Users/deepak/Desktop/project";
    public static final String pomLocation = "template/pom.xml";
    public static String applicationClassLocation = "template/DemoApplication.java";
    public static final String srcMainJavaLoc = projectLocation + "/src/main/java";
    public static final String resourceLoc = projectLocation + "/src/main/resources";
    public static final String applicationProp = "template/application.properties";
    public static String applicationClassName;
    public static String javaCodeLoc;

    @Autowired
    private FileUtilService fileUtilService;

    /**
     *  makeEmptyProject(request);
        makeApplicationProperty();
        makePomXml();
        addDependencies();
        addMainApplicaitonJava();
        addDatabaseProps();
        addDatabaseDto();
        addLogging();
     */
    @Override
    public void createProject(Request request) throws IOException {
        Properties properties = request.getProperties();
        applicationClassName = Common.toCamelCase(request.getProperties()
            .getGroupId()) + "Application";
        logger.info("Application Class Name => " + applicationClassName);
        properties.setApplicationClassName(applicationClassName);
        this.makeEmptyProject(request);
        String applicationPropData = fileUtilService.getDataFromClassLoader(applicationProp);
        this.makePomXml(request);
    }

    /**
     *  mkdir src/main/java && src/main/resources
     *  add pom.xml in project folder && add README.md in project folder &&  add .gitignore in the project folder
     */
    private void makeEmptyProject(Request request) throws IOException {
        logger.info("javaCodeLoc => " + javaCodeLoc);
        javaCodeLoc = getJavaCodeLoc(request);
        logger.info("javaCodeLoc => " + javaCodeLoc);
        fileUtilService.createDirectories(srcMainJavaLoc);
        fileUtilService.createDirectories(resourceLoc);
        fileUtilService.createDirectories(javaCodeLoc);
        fileUtilService.createDirectories(javaCodeLoc+"/service/impl");
        fileUtilService.createDirectories(javaCodeLoc+"/controller");
        fileUtilService.createDirectories(javaCodeLoc+"/exception");
        fileUtilService.createDirectories(javaCodeLoc+"/dao");
        fileUtilService.createDirectories(javaCodeLoc+"/entity");
    }

    private String getJavaCodeLoc(Request request) {
        return (srcMainJavaLoc + "." + request.getProperties()
            .getArtifactId() + "."
            + request.getProperties()
                .getGroupId()).replaceAll("\\.", "/");
    }

    private void addLogging() {

    }

    private void addDatabaseDto() {

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

    private void makePomXml(Request request) throws IOException {
        String pomXmlData = fileUtilService.getDataFromClassLoader(pomLocation);
        Map<String, String> objectMapString = JacksonParser.jacksonObjectToMap(request.getProperties());
        pomXmlData = Common.replaceParams(pomXmlData, objectMapString);
        fileUtilService.writeDataToFile(pomXmlData, projectLocation + "/" + "pom.xml");
        String applicationClassData = fileUtilService.getDataFromClassLoader(applicationClassLocation);
        applicationClassData = Common.replaceParams(applicationClassData, objectMapString);
        fileUtilService.writeDataToFile(applicationClassData, javaCodeLoc + "/" + applicationClassName + ".java");
    }

    private void makeApplicationProperty() {
        // TODO make application properties

    }

}
