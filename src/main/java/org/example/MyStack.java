package org.example;

import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;

import java.util.Optional;

public class MyStack implements Stackable{
    private int mSize; //mSize - максимальный размер
    private Integer[] stackArray;
    private int top;

    public MyStack(int m) {
        this.mSize = m;
        stackArray = new Integer[mSize];
        top = -1;
    }

    @Override
    public void addElement(Integer element) throws StackOverflow{
        if (top+1 == mSize) throw new StackOverflow();
        stackArray[++top] = element;
    }
    @Override
    public Integer deleteElement() throws StackEmpty{
        if (top == -1) throw new StackEmpty();
        return stackArray[top--];
    }
    @Override
    public Integer readTop() throws StackEmpty{
        if (top == -1) throw new StackEmpty();
        return stackArray[top];
    }
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }
    @Override
    public boolean isFull() {
        return (top == mSize - 1);
    }

    @Override
    public Optional<Integer> getElement(int index){

        return Optional.of(getElementOptional(index));
    }

    public Integer getElementOptional(int index) {
        int l = top;
        for (int i = l; i>=0; i--){
            if (i == index) l = i;
        }
        return stackArray[l];
    }
}
