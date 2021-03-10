package com.revature.collections;

import java.lang.reflect.Array;
import java.util.Arrays;

// generic array from: https://www.baeldung.com/java-generic-array

// E that contains an array
// makes a new array with a larger size each time an element is added
@SuppressWarnings("ALL")
public class FlexArray<E>{

    protected E[] elements;
    protected final Class<?> clazz;

    public FlexArray(Class<?> clazz){
        this.clazz = clazz;
        elements = array(0);
    }

    public FlexArray(Class<?> clazz, E[] e){
        this.clazz = clazz;
        elements = e;
    }

    private E[] array(int length){
        return (E[]) Array.newInstance(clazz, length);
    }

    public void add(E e) {
        E[] newArray = array(elements.length + 1);
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        // add new element
        newArray[elements.length] = e;
        elements = newArray;
    }

    public void add(E[] newElements) {
        E[] newArray = array(elements.length + newElements.length);
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        System.arraycopy(newElements, 0, newArray, elements.length, newElements.length);
        // add new elements
        elements = newArray;
    }

    // removes any element of the internal array that matches o by making a new array of reduced size without those elements
    public void remove(E e) {
        int removalIndex = -1;
        // number of items removed -1
        int removalCount = -1;
        boolean loop = true;
        boolean remove;
        E[] prevArray;
        E[] result = elements;
        do {
            remove = false;
            for (int i = removalIndex+1; i < elements.length; i++) {
                // check if this is last loop
                if (i == elements.length-1) {
                    loop = false;
                }
                if (elements[i].equals(e)) {
                    removalIndex = i;
                    removalCount++;
                    remove = true;
                    break;
                }
            }
            if(remove){
                // result will be one less in length for each removal we find
                prevArray = result;
                result = array(result.length-1);
                // prevArray will have length of (array - removalCount + 1)
                System.arraycopy(prevArray, 0, result, 0, removalIndex-removalCount);
                System.arraycopy(prevArray, removalIndex-removalCount+1, result, removalIndex-removalCount, result.length-(removalIndex-removalCount));
            }
        } while(loop);
        elements = result;
    }

    // replaces array with an array without the element at index i an with length -1
    // should throw an exception if the index given is out of scope
    public void remove(int i) {
        E[] result = array(elements.length-1);
        System.arraycopy(elements, 0, result, 0, i);
        System.arraycopy(elements, i+1, result, i, elements.length-i-1);
        elements = result;
    }

    public E get(int index){ return elements[index]; }

    public boolean isEmpty() {
        for (E e : elements) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    // Bubble Sort
    public void order() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i].toString().compareTo(elements[j].toString()) > 0) {
                    E temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    //Returns index of user in array or -1 if user isn't found
    public int indexOf(E u) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return elements.length;
    }

    public String[] toStringArray(){
        String[] result = new String[elements.length];
        for (int i = 0; i < elements.length; i++){
            result[i] = elements[i].toString();
        }
        return result;
    }

    public String toString() {
        String[] strings = toStringArray();
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s).append(System.lineSeparator());
        }
        return result.toString();
    }

    public E[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    public boolean has(E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // sets elements to an empty array
    public void Clear() {
        elements = array(0);
    }
}
