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
        for(int i = 0; i<array.length; i++){

            newArray[i] = array[i];
        }
        newArray[array.length] = newElement;
        array = newArray;
    }

    public Object[] toArray() {
        return array;
    }
}
