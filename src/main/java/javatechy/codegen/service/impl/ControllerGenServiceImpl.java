package javatechy.codegen.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javatechy.codegen.common.Common;
import javatechy.codegen.dto.Controller;
import javatechy.codegen.dto.Request;
import javatechy.codegen.service.ControllerGenService;
import javatechy.codegen.service.FileUtilService;

@Service
public class ControllerGenServiceImpl implements ControllerGenService {

    @Autowired
    private FileUtilService fileUtilService;

    @Override
    public void generateControllers(Request request) throws IOException {
        List<Controller> controllers = request.getControllers();
        for (Controller controler : controllers) {
            String className = controler.getName();
            String docsComment = controler.getDocsComment();
            String controllerClassData = fileUtilService.getDataFromClassLoader(ProjectServiceImpl.controllerClassLocation);
            controllerClassData = Common.replaceParams(controllerClassData, "name", className);
            controllerClassData = Common.replaceParams(controllerClassData, "docsComment", docsComment);
            controllerClassData = Common.replaceParams(controllerClassData, "docsComment", docsComment);
            
            fileUtilService.writeDataToFile(controllerClassData, ProjectServiceImpl.javaCodeLoc + "/controllers/" + className + ".java");
        }
    }
}
