package javatechy.codegen;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectoryCreation {

    private static String projectLocation = "/Users/deepak/Desktop";

    @Test
    public void test() throws IOException {
        String artifactId = "com.demo";
        String groupId = "test";
        Path path = Paths.get((projectLocation + "." + artifactId + "." + groupId).replace(".", "/"));
        System.out.println("File Location=> " + path.toString());
        Files.createDirectories(path);
    }

}
