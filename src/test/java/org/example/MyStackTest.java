package org.example;

import junit.framework.TestCase;
import org.example.Exceptions.DoesNotExist;
import org.example.Exceptions.StackEmpty;
import org.example.Exceptions.StackOverflow;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MyStackTest extends TestCase {

    private MyStack mStack;
    /*@BeforeClass
    public void initialize(){
        mStack = new MyStack(4);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
    }*/

    @Test
    public void testAddElement() {
        mStack = new MyStack(4);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
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
        mStack = new MyStack(4);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        try {
            mStack.addElement(34);
        }catch (StackOverflow stackOverflow){
            assertEquals("Stack is full, so you can't add more elements", stackOverflow.toString());
        }

    }

    @Test

    public void testDeleteElement() {
        MyStack mStack = new MyStack(10);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        mStack.deleteElement();

        assertEquals(mStack.readTop(), 35 );
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
        MyStack mStack = new MyStack(10);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        mStack.deleteElement();

        assertEquals(79, mStack.getElement(0) );
    }

    @Test
    public void testGetElementException(){
        MyStack mStack = new MyStack(10);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        mStack.deleteElement();

        try {
            mStack.getElement(5);
        }catch (DoesNotExist doesNotExist){
            assertEquals("Stack doesn't contain this element", doesNotExist.toString());
        }
    }
}