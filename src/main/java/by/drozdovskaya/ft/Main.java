package by.drozdovskaya.ft;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import by.drozdovskaya.ft.factory.impl.CustomArrayFactoryImpl;
import by.drozdovskaya.ft.reader.impl.CustomFileReaderImpl;
import by.drozdovskaya.ft.repository.impl.CustomArrayRepositoryImpl;
import by.drozdovskaya.ft.specification.impl.SumRangeSpecification;
import by.drozdovskaya.ft.comparator.IdComparator;
import by.drozdovskaya.ft.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String FILE_PATH = "src/main/resources/data.txt";

    public static void main(String[] args) {
        CustomFileReaderImpl reader = new CustomFileReaderImpl();
        ArrayValidatorImpl validator = new ArrayValidatorImpl();
        CustomArrayFactoryImpl factory = new CustomArrayFactoryImpl();

        CustomArrayRepositoryImpl repository = CustomArrayRepositoryImpl.getInstance();

        try {
            List<String> lines = reader.readLines(FILE_PATH);

            for (String line : lines) {
                if (validator.isValid(line)) {
                    try {
                        CustomArray array = factory.createArrayFromLine(line);
                        repository.add(array);
                    } catch (ArrayException e) {
                        logger.error("Line parse error: {}", line);
                    }
                }
            }

            int total = repository.query(a -> true).size();
            logger.info("Total arrays in repository: {}", total);

            if (total > 0) {
                List<CustomArray> found = repository.query(new SumRangeSpecification(10, 50));
                logger.info("Search result (Sum 10-50): {} items found", found.size());

                List<CustomArray> sorted = repository.sort(new IdComparator());
                logger.info("Sort by ID completed. First ID: {}", sorted.get(0).getId());
            }

        } catch (ArrayException e) {
            logger.error("Critical error: {}", e.getMessage());
        }
    }
}