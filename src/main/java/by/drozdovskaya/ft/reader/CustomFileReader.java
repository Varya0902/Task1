package by.drozdovskaya.ft.reader;

import by.drozdovskaya.ft.exception.ArrayException;
import java.util.List;

public interface CustomFileReader {
    List<String> readLines(String FilePath) throws ArrayException;
}
