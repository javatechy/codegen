package javatechy.codegen.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javatechy.codegen.service.FileUtilService;

@Service
public class FileUtilServiceImpl implements FileUtilService {
    private static Logger logger = Logger.getLogger(FileUtilServiceImpl.class);

    private ClassLoader classLoader = getClass().getClassLoader();

    public void copyFile(String jsonStr) {
    }

    @Override
    public String getFileNameFromClassLoader(String fileLoc) {
        String fileName = classLoader.getResource(fileLoc)
            .getFile();
        return fileName;
    }

    @Override
    public void createDirectories(String location) throws IOException {
        logger.info("[createDirectories]File Location=> " + location);
        Path path = Paths.get(location);
        logger.info("[createDirectories]File Location=> " + path.toString());
        Files.createDirectories(path);
    }

    @Override
    public String readFileData(String fileName) throws IOException {
        logger.info("Reading file => " + fileName);
        String data = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        logger.info("Data read  from " + fileName + " => " + data);
        return data;
    }

    @Override
    public void copyFileToDestDir(String sourceFile, String destDir) {
    }

    @Override
    public String getDataFromClassLoader(String fileLoc) throws IOException {
        return readFileData(this.getFileNameFromClassLoader(fileLoc));
    }

    @Override
    public void writeDataToFile(String data, String fileName) throws IOException {
        Files.write(Paths.get(fileName), data.getBytes());
    }

}
