package com.compilers;

/**
 * Created by Windows 8 on 27-May-17.
 */
public class scopeEntry {
    int id;
    int elements;
    String value;

    public scopeEntry(int id, int elements) {
        this.id = id;
        this.elements = elements;
        this.value="";
    }

    @Override
    public String toString() {
        return "scopeEntry{" +
                "id=" + id +
                ", elements=" + elements +
                ", value='" + value + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public scopeEntry(int id, int elements, String value) {

        this.id = id;
        this.elements = elements;
        this.value = value;
    }
    public int increaseElements(){
        this.elements++;
        return this.elements;
    }
}
