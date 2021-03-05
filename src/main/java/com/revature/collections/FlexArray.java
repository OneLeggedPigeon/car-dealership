package com.revature.collections;

// Object that contains an array
// makes a new array with a larger size each time an element is added
public class FlexArray<T>{

    protected Object[] array;

    public FlexArray(){
        array = new Object[0];
    }
    public FlexArray(T[] array){
        this.array = array;
    }

    public void add(T t) {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = t;
        array = newArray;
    }

    public void add(T[] newElements) {
        Object[] newArray = new Object[array.length + newElements.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(newElements, 0, newArray, array.length, newElements.length);
        // add new elements
        array = newArray;
    }

    // removes any element of the internal array that matches o by making a new array of reduced size without those elements
    public void remove(T t) {
        int removalIndex = -1;
        // number of items removed -1
        int removalCount = -1;
        boolean loop = true;
        boolean remove;
        Object[] prevArray;
        Object[] result = array;
        do {
            remove = false;
            for (int i = removalIndex+1; i < array.length; i++) {
                // check if this is last loop
                if (i == array.length-1) {
                    loop = false;
                }
                if (array[i].equals(t)) {
                    removalIndex = i;
                    removalCount++;
                    remove = true;
                    break;
                }
            }
            if(remove){
                // result will be one less in length for each removal we find
                prevArray = result;
                result = new Object[result.length-1];
                // prevArray will have length of (array - removalCount + 1)
                System.arraycopy(prevArray, 0, result, 0, removalIndex-removalCount);
                System.arraycopy(prevArray, removalIndex-removalCount+1, result, removalIndex-removalCount, result.length-(removalIndex-removalCount));
            }
        } while(loop);
        array = result;
    }

    // replaces array with an array without the element at index i an with length -1
    // should throw an exception if the index given is out of scope
    public void remove(int i) {
        Object[] result = new Object[array.length-1];
        System.arraycopy(array, 0, result, 0, i);
        System.arraycopy(array, i+1, result, i, array.length-i-1);
        array = result;
    }

    public Object get(int index){ return array[index]; }

    public boolean isEmpty() {
        for (Object t : array) {
            if (t != null) {
                return false;
            }
        }
        return true;
    }

    // Bubble Sort
    public void order() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].toString().compareTo(array[j].toString()) > 0) {
                    Object temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //Returns index of user in array or -1 if user isn't found
    public int indexOf(T u) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return array.length;
    }

    public String[] toStringArray(){
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i].toString();
        }
        return result;
    }

    public String toString() {
        String[] strings = toStringArray();
        String result = "";
        for (String s : strings) {
            result = result.concat(s + System.lineSeparator());
        }
        return result;
    }

    public Object[] toArray() {
        return array;
    }
}
