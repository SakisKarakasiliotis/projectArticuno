package com.compilers;

import com.sun.javafx.binding.StringFormatter;

/**
 * Created by Windows 8 on 26-May-17.
 */
public class symbolTableEntry {

    String id;
    String type;

    @Override
    public String toString() {
        return "symbolTableEntry{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public symbolTableEntry(String id, String type) {

        this.id = id;
        this.type = type;

    }

}
