package org.example.Exceptions;

public class StackEmpty extends Error{

    @Override
    public String toString() {
        return "Stack is empty, so u can't get the element or delete it";
    }
}
