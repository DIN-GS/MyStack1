package org.example;

import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;

import java.util.Stack;

public interface Stackable {
    void addElement(int element) throws StackOverflow;

    int deleteElement() throws StackEmpty;
    int readTop() throws StackEmpty;
    int getElement(int index) throws DoesNotExist;

    boolean isEmpty();

    boolean isFull();
}
