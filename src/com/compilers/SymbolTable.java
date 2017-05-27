package com.compilers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Windows 8 on 27-May-17.
 */
public class SymbolTable {

    private List<Stack<symbolTableEntry>> scopes = new LinkedList<>();


    public void enter(){
        scopes.add(new Stack<symbolTableEntry>());

    }

    public int insert(String name, String type){

        Stack latestScope = scopes.get(scopes.size() - 1);

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public boolean lookup(String name){
        Stack latestScope = scopes.get(scopes.size() - 1);
        for (int i = 0; i < latestScope.size(); i++) {
            symbolTableEntry temp = (symbolTableEntry)latestScope.get(i);
            if(name.equals(temp.getId())){
                return true;
            }
        }
        return false;
    }

    public int exit(){
        scopes.remove(scopes.size()-1);
        return 0;
    }


    @Override
    public String toString() {
        return "SymbolTable{" +
                "scopes=" + scopes +
                '}';
    }

    public List<Stack<symbolTableEntry>> getScopes() {
        return scopes;
    }

    public void setScopes(List<Stack<symbolTableEntry>> scopes) {
        this.scopes = scopes;
    }

    public SymbolTable(List<Stack<symbolTableEntry>> scopes) {

        this.scopes = scopes;
    }

    public SymbolTable() {
    }
}
