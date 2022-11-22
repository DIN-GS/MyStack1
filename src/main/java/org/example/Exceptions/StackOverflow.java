package org.example.Exceptions;

public class StackOverflow extends Error{
    @Override
    public String toString() {
        return "Stack is full, so you can't add more elements";
    }
}
