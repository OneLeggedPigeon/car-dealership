package com.revature.collections;

// Object that contains an array
// makes a new array with a larger size each time an element is added
public class FlexArray {

    protected Object[] array;

    public FlexArray(){
        array = new Object[0];
    }
    public FlexArray(Object[] array){
        this.array = array;
    }

    public void add(Object newElement) {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = newElement;
        array = newArray;
    }

    public void add(Object[] newElements) {
        Object[] newArray = new Object[array.length + newElements.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(newElements, 0, newArray, array.length, newElements.length);
        // add new elements
        array = newArray;
    }


    //TODO: check against array length
    public Object get(int index){
        return array[index];
    }

    public String[] getStringArray(){
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i].toString();
        }
        return result;
    }

    public Object[] toArray() {
        return array;
    }

    public int length(){
        return array.length;
    }
}
