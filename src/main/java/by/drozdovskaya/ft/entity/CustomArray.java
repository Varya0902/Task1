package by.drozdovskaya.ft.entity;

import by.drozdovskaya.ft.observer.ArrayObserver;
import by.drozdovskaya.ft.observer.impl.ArrayObserverImpl;

import java.util.Arrays;

public class CustomArray {
    private static long counter = 1;

    private final long id;
    private int[] elements;
    private ArrayObserver observer = new ArrayObserverImpl();

    public CustomArray(int[] elements) {
        this.id = counter++;
        this.elements = elements;
    }

    public long getId() {
        return id;
    }

    public int[] getElements() {
        return Arrays.copyOf(elements, elements.length);
    }

    public void setElements(int[] elements) {
        this.elements = elements;
        notifyObserver();
    }

    public void setElement(int index, int value) {
        this.elements[index] = value;
        notifyObserver();
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return id == that.id && Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("id=").append(id);
        sb.append(", elements=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }
}