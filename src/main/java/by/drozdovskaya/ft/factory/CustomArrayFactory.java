package by.drozdovskaya.ft.factory;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;

public interface CustomArrayFactory {
    CustomArray createArray(int[] elements);
    CustomArray createArrayFromLine(String line) throws ArrayException;
}