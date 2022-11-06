package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class MyStackTest extends TestCase {

    public void testAddElement() {
        MyStack mStack = new MyStack(10);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        int[] mas = new int[4];
        for (int i = 0; i < 4; i ++){
            mas[i] = mStack.readTop();
        }
        int[] m = {24, 35, 59, 79};
        assertArrayEquals(m, mas);
    }

    public void testDeleteElement() {
        MyStack mStack = new MyStack(10);
        mStack.addElement(79);
        mStack.addElement(59);
        mStack.addElement(35);
        mStack.addElement(24);
        mStack.deleteElement();
        int[] mas = new int[4];

        assertEquals(mStack.readTop(), 59);
    }
}