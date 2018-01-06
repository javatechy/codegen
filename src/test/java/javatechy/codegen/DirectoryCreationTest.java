package javatechy.codegen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DirectoryCreationTest {

    static Logger logger = Logger.getLogger(DirectoryCreationTest.class);
    private static String projectLocation = "/Users/deepak/Desktop";

    public static void main(String a[]) throws JsonParseException, JsonMappingException, IOException {
        String artifactId = "com.demo";
        String groupId = "test";
        Path path = Paths.get((projectLocation + "." + artifactId + "." + groupId).replace(".", "/"));
        System.out.println("File Location=> " + path.toString());
        Files.createDirectories(path);
    }

}
