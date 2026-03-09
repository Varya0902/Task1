package by.drozdovskaya.ft.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] elements;

    public CustomArray(int[] elements) {
        this.elements = elements;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("elements=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }
}
