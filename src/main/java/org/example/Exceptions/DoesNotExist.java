package org.example.Exceptions;

public class DoesNotExist extends Error{

    @Override
    public String toString() {
        return "Stack doesn't contain this element";
    }
}
