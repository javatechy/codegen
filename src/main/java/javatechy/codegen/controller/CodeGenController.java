package javatechy.codegen.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javatechy.codegen.dto.Request;
import javatechy.codegen.dto.Response;
import javatechy.codegen.service.ProjectService;

@Api(value = "Project Controller")
@CrossOrigin(origins = "*")
@RequestMapping("project")
@RestController
public class CodeGenController {

    @Autowired
    private ProjectService projectService;

    private Logger logger = Logger.getLogger(CodeGenController.class);

    @ApiOperation(value = "Create a project")
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createProject(@RequestBody Request request) {
        logger.info("Recieved Request => " + request);
        projectService.createProject(request);
        return null;
    }

}
