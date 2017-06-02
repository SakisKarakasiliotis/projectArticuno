package com.compilers;

import com.sun.javafx.binding.StringFormatter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Windows 8 on 26-May-17.
 */
public class symbolTableEntry {

    String id;
    List<symbolTableEntry> fParams;
    EntryType type;
    EntryType parent;
    String retType;
    String fParType;

    public String getfParType() {
        return fParType;
    }

    public void setfParType(String fParType) {
        this.fParType = fParType;
    }

    public String getRetType() {
        return retType;
    }

    public void setRetType(String retType) {
        this.retType = retType;
    }

    @Override
    public String toString() {
        return "symbolTableEntry{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    public symbolTableEntry(String id, EntryType type, EntryType parent) {
        this.id = id;
        this.type = type;
        this.parent = parent;
        this.fParams = new LinkedList<>();
    }

    public List<symbolTableEntry> getfParams() {
        return fParams;
    }

    public void setfParams(List<symbolTableEntry> fParams) {
        this.fParams = fParams;
    }

    public EntryType getParent() {
        return parent;
    }

    public void setParent(EntryType parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }



    public symbolTableEntry(String id, EntryType type) {

        this.id = id;
        this.type = type;

    }

}

