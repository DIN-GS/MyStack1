package org.example;

import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyStackTest  {

    private MyStack mStack;
    @BeforeAll
    public void initialize(){
        mStack = new MyStack(4);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
    }

    @Test
    public void testAddElement() {

        int[] mas = new int[4];
        for (int i = 0; i < 4; i ++){
            mas[i] = mStack.readTop();
            mStack.deleteElement();
        }
        int[] m = {24, 35, 59, 79};
        assertArrayEquals(m, mas);
    }
    @Test
    public void testAddElementException(){

        try {
            mStack.addElement(34);
        }catch (StackOverflow stackOverflow){
            assertEquals("Stack is full, so you can't add more elements", stackOverflow.toString());
        }

    }

    @Test

    public void testDeleteElement() {

        mStack.deleteElement();

        assertEquals(new Integer(35), mStack.readTop() );
    }

    @Test
    public void testDeleteElementException(){
        MyStack mStack = new MyStack(10);

        try {
            mStack.deleteElement();
        }catch (StackEmpty stackEmpty){
            assertEquals("Stack is empty, so u can't get the element or delete it", stackEmpty.toString());
        }
    }

    @Test
    public void testGetElement() {

        mStack.deleteElement();
        Optional<Integer> optional = mStack.getElement(0);
        Integer number = optional.get();
        assertEquals(new Integer(79), number);
    }

    @Test
    public void testGetElementException(){

        mStack.deleteElement();

        try {
            mStack.getElement(5);
        }catch (DoesNotExist doesNotExist){
            assertEquals("Stack doesn't contain this element", doesNotExist.toString());
        }
    }
}