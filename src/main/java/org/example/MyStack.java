package org.example;

import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;

public class MyStack implements Stackable{
    private int mSize; //mSize - максимальный размер
    private int[] stackArray;
    private int top;

    public MyStack(int m) {
        this.mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }

    @Override
    public void addElement(int element) throws StackOverflow{
        if (top+1 == mSize) throw new StackOverflow();
        stackArray[++top] = element;
    }
    @Override
    public int deleteElement() throws StackEmpty{
        if (top == -1) throw new StackEmpty();
        return stackArray[top--];
    }
    @Override
    public int readTop() throws StackEmpty{
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
    public int getElement(int index) throws DoesNotExist{
        int l = top;
        for (int i = l; i>=0; i--){
            if (i == index) return stackArray[i];
        }
        throw new DoesNotExist();
    }
}
