package by.drozdovskaya.ft;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import by.drozdovskaya.ft.factory.impl.CustomArrayFactoryImpl;
import by.drozdovskaya.ft.reader.impl.CustomFileReaderImpl;
import by.drozdovskaya.ft.service.impl.CustomArrayServiceImpl;
import by.drozdovskaya.ft.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "src/main/resources/data.txt";

    public static void main(String[] args) {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        ArrayValidatorImpl validator = new ArrayValidatorImpl();
        CustomArrayFactoryImpl factory = new CustomArrayFactoryImpl();
        CustomArrayServiceImpl service = new CustomArrayServiceImpl();

        try {
            logger.info("Reading file: {}", FILE_PATH);
            List<String> lines = reader.readLines(FILE_PATH);
            List<CustomArray> arrays = new ArrayList<>();

            for (String line : lines) {
                if (validator.isValid(line)) {
                    try {
                        CustomArray array = factory.createArrayFromLine(line);
                        arrays.add(array);
                    } catch (ArrayException e) {
                        logger.warn("Parse error in line: {}", line);
                    }
                } else {
                    logger.warn("Invalid format: {}", line);
                }
            }

            logger.info("Created {} arrays", arrays.size());

            for (CustomArray array : arrays) {
                logger.info("------------------------------");
                logger.info("Array: {}", array);
                logger.info("Min: {}", service.findMin(array));
                logger.info("Max: {}", service.findMax(array));
                logger.info("Sum: {}", service.calculateSum(array));

                service.sortBubble(array);
                logger.info("Sorted: {}", array);
            }

        } catch (ArrayException e) {
            logger.error("App error: ", e);
        }
    }
}