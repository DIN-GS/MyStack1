package org.example;

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
    public void addElement(int element) {
        stackArray[++top] = element;
    }
    @Override
    public int deleteElement() {
        return stackArray[top--];
    }
    @Override
    public int readTop() {
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
}
