package javatechy.codegen.service;

import java.io.IOException;

import javatechy.codegen.dto.Request;

public interface PomMakerService {

    void createProject(Request request) throws IOException;
}
