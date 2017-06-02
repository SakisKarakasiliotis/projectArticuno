package com.compilers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Windows 8 on 27-May-17.
 *
 */


public class SymbolTable {

    private List<Stack<symbolTableEntry>> scopes = new LinkedList<>();


    public void enter(){
        scopes.add(new Stack<symbolTableEntry>());

    }

    public int insert(String name, EntryType type, EntryType parent){

        Stack latestScope = scopes.get(scopes.size() - 1);

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type, parent);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public int insert(symbolTableEntry input){

        Stack latestScope = scopes.get(scopes.size() - 1);

        latestScope.push(input);
        return 0;
    }

    public int insertToParent(String name, EntryType type, EntryType parent){
        Stack latestScope;
        if(scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        }else{
            latestScope = scopes.get(scopes.size() - 1);
        }

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type, parent);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public int insertToParent(symbolTableEntry input){
        Stack latestScope;
        if(scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        }else{
            latestScope = scopes.get(scopes.size() - 1);
        }

        latestScope.push(input);

        return 0;
    }

    public symbolTableEntry lookup(String name){
        Stack latestScope = scopes.get(scopes.size() - 1);
        for (int i = latestScope.size()-1; i >=0 ; i--) {
            symbolTableEntry temp = (symbolTableEntry)latestScope.get(i);
            if(name.equals(temp.getId())){
                return temp;
            }
        }

        return null;
    }

    public int getLastElementPos(){
        return scopes.get(scopes.size() - 1).size()-1;
    }

    public symbolTableEntry getLastElement(int pos){
        return scopes.get(scopes.size() - 1).get(pos);
    }



    public symbolTableEntry lookupWithScope(String name){
        if(scopes.isEmpty()){
            return null;
        }
        System.out.println(scopes.size());
        for (int i = scopes.size() -1; i >=0 ; i--) {
            System.out.println(i);
            Stack latestScope = scopes.get(i);
            if(latestScope.isEmpty()){
                continue;
            }
            for (int j = latestScope.size() - 1; j >= 0 ; j--) {
                symbolTableEntry temp = (symbolTableEntry)latestScope.get(j);
                System.out.println("i "+i+" j "+j+" temp "+ temp+" name "+name);
                if(name.equals(temp.getId())){
                    return temp;
                }
            }
        }
        return null;

    }

    public int exit(){
        scopes.remove(scopes.size()-1);
        System.out.println("scopes" +scopes.size());

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
