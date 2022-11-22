package org.example;

import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;

import java.util.Optional;

public interface Stackable {
    void addElement(Integer element) throws StackOverflow;

    Integer deleteElement() throws StackEmpty;
    Integer readTop() throws StackEmpty;
    Optional<Integer> getElement(int index);

    boolean isEmpty();

    boolean isFull();
}
