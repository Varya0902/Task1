package by.drozdovskaya.ft.service;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;

public interface CustomArrayService {
    int findMin(CustomArray array) throws ArrayException;
    int findMax(CustomArray array) throws ArrayException;
    int calculateSum(CustomArray array) throws ArrayException;
    void sortBubble(CustomArray array) throws ArrayException;
    void sortInsertion(CustomArray array) throws ArrayException;
}