package com.compilers;

import com.sun.javafx.binding.StringFormatter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Windows 8 on 26-May-17.
 */
public class symbolTableEntry {

    String id;
    private List<symbolTableEntry> fParams;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        symbolTableEntry that = (symbolTableEntry) o;

        if (initialized != that.initialized) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fParams != null ? !fParams.equals(that.fParams) : that.fParams != null) return false;
        if (type != that.type) return false;
        if (parent != that.parent) return false;
        if (retType != null ? !retType.equals(that.retType) : that.retType != null) return false;
        return fParType != null ? fParType.equals(that.fParType) : that.fParType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fParams != null ? fParams.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (retType != null ? retType.hashCode() : 0);
        result = 31 * result + (fParType != null ? fParType.hashCode() : 0);
        result = 31 * result + (initialized ? 1 : 0);
        return result;
    }

    EntryType type;
    EntryType parent;
    String retType;
    String fParType;
    boolean initialized;

    public String getfParType() {
        return fParType;
    }

    public void setfParType(String fParType) {
        this.fParType = fParType.trim();
    }

    public String getRetType() {
        return retType;
    }

    public void setRetType(String retType) {
        this.retType = retType.trim();
    }


    @Override
    public String toString() {
        return "symbolTableEntry{" +
                "id='" + id + '\'' +
                ", fParams=" + fParams +
                ", type=" + type +
                ", parent=" + parent +
                ", retType='" + retType + '\'' +
                ", fParType='" + fParType + '\'' +
                ", Initialized='"+ initialized+'\''+
                '}';
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public symbolTableEntry(String id, EntryType type, EntryType parent) {
        this.id = id.trim();
        this.type = type;
        this.parent = parent;
        this.retType = "";
        this.fParType = "";
        this.fParams = null;
        this.initialized = false;

    }

    public List<symbolTableEntry> getfParams() {
        return fParams;
    }

    public void setfParams(List<symbolTableEntry> fParams) {
        this.fParams = new LinkedList<>(fParams);
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

        this.id = id.trim();
        this.type = type;
        this.parent = EntryType.NOTHING;

    }

}

