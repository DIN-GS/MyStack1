package org.example;

public interface Stackable {
    void addElement(int element);

    int deleteElement();
    int readTop();

    boolean isEmpty();

    boolean isFull();
}
