package com.revature.collections;

// Object that contains an array
// makes a new array with a larger size each time an element is added
public class FlexArray {

    private Object[] array;

    public FlexArray(){
        array = new Object[0];
    }
    public FlexArray(Object[] array){
        this.array = array;
    }

    public void add(Object newElement) {

        Object[] newArray = new Object[array.length+1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = newElement;
        array = newArray;
    }

    //TODO: check against array length
    public Object get(int index){
        return array[index];
    }

    public Object[] toArray() {
        return array;
    }

    public int length(){
        return array.length;
    }
}
