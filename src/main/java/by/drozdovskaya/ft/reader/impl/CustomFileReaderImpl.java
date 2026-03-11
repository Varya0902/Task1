package by.drozdovskaya.ft.reader.impl;

import by.drozdovskaya.ft.reader.CustomFileReader;
import by.drozdovskaya.ft.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReaderImpl.class);

    @Override
    public List<String> readLines(String filePath) throws ArrayException {
        if (filePath == null) {
            logger.error("File path is null");
            throw new ArrayException("File path cannot be null");
        }

        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            logger.error("File error: {}", filePath);
            throw new ArrayException("Read error", e);
        }
    }
}