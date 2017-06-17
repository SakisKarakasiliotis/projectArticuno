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

    public void loadLibraries() {
        if (scopes.size() == 1) {
            String[] names = {"puti", "putc", "puts", "geti", "getc", "gets", "abs", "ord", "chr", "strlen", "strcmp", "strcpy", "strcat"};
            String[] returns = {"nothing", "nothing", "nothing", "int", "char", "nothing", "int", "int", "char", "int", "int", "nothing", "nothing"};
            String[][] params = {
                    {"n"},
                    {"c"},
                    {"s"},
                    {""},
                    {""},
                    {"n", "s"},
                    {"n"},
                    {"c"},
                    {"n"},
                    {"s"},
                    {"s1", "s2"},
                    {"trg", "src"},
                    {"trg", "src"}
            };
            String[][] paramtype = {
                    {"int"},
                    {"char"},
                    {"char[]"},
                    {""},
                    {""},
                    {"int", "char[]"},
                    {"int"},
                    {"char"},
                    {"int"},
                    {"char[]"},
                    {"char[]", "char[]"},
                    {"char[]", "char[]"},
                    {"char[]", "char[]"}
            };
            for (int i=0; i<names.length; i++){
                symbolTableEntry s = new symbolTableEntry(names[i], EntryType.FUNC_NAME, EntryType.FUNC_DEF);
                s.setRetType(returns[i]);
                List<symbolTableEntry> fParams = new LinkedList<>();
                for (int j = 0; j < params[i].length; j++) {
                    symbolTableEntry temp = new symbolTableEntry(params[i][j], EntryType.FUNC_PARAM, EntryType.FUNC_DEF);
                    temp.setRetType(paramtype[i][j]);
                    temp.setfParType(paramtype[i][j]);
                    fParams.add(temp);
                }
                s.setfParams(fParams);
                Stack latestScope = scopes.get(0);
                latestScope.push(s);
            }
        }
    }

    public void enter() {
        scopes.add(new Stack<symbolTableEntry>());
        loadLibraries();
        System.out.println("Enter scope: " + (scopes.size() - 1));
    }

    public int insert(String name, EntryType type, EntryType parent) {

        Stack latestScope = scopes.get(scopes.size() - 1);

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type, parent);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public int insert(symbolTableEntry input) {
        // System.out.println(input);

        Stack latestScope = scopes.get(scopes.size() - 1);

        latestScope.push(input);
        return 0;
    }

    public int insertToParent(String name, EntryType type, EntryType parent) {

        Stack latestScope;
        if (scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        } else {
            latestScope = scopes.get(scopes.size() - 1);
        }

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type, parent);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public int insertToParent(symbolTableEntry input) {
        // System.out.println(input);
        Stack latestScope;
        if (scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        } else {
            latestScope = scopes.get(scopes.size() - 1);
        }

        latestScope.push(input);

        return 0;
    }

    public symbolTableEntry lookup(String name) {
        Stack latestScope = scopes.get(scopes.size() - 1);
        for (int i = latestScope.size() - 1; i >= 0; i--) {
            symbolTableEntry temp = (symbolTableEntry) latestScope.get(i);
            if (name.equals(temp.getId())) {
                return temp;
            }
        }

        return null;
    }

    public symbolTableEntry getFunctionEntry() {
        Stack latestScope;

        if (scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        } else {
            latestScope = scopes.get(scopes.size() - 1);
        }
        while (!latestScope.isEmpty()) {
            symbolTableEntry temp = (symbolTableEntry) latestScope.pop();
            if (temp.getType().equals(EntryType.FUNC_NAME) && temp.getParent().equals(EntryType.FUNC_DEF)) {
                return temp;
            }
        }
        return null;

    }

    public symbolTableEntry lookup(String name, EntryType type) {

        int scopeCounter = scopes.size() - 1;
        for (Stack latestScope : scopes
                ) {
            for (int i = latestScope.size() - 1; i >= 0; i--) {
                symbolTableEntry temp = (symbolTableEntry) latestScope.get(i);
//                System.out.println("scope "+ scopeCounter + " " + i+" "+temp.getId());
//                System.out.println("comparing with " +temp.getId()+" "+temp.getType());
                if (name.equals(temp.getId())) {

                    return temp;
                } else if (temp.getType().equals(EntryType.FUNC_NAME)) {
//                    System.out.println("im hgere"+temp.getfParams().size());
                    for (symbolTableEntry a : temp.getfParams()) {
//                        System.out.println("in list comparing "+ a.getId());
                        if (a.getId().equals(name)) {
                            return a;
                        }
                    }
                }
            }
            scopeCounter++;
        }

        return null;
    }

    public void print() {
        System.out.println("----------------------------------------------------");
        System.out.println("START SYMBOL TABLE");
        System.out.println("----------------------------------------------------");
        for (int j = 0; j < scopes.size(); j++) {
            Stack<symbolTableEntry> st = scopes.get(j);
            System.out.println(j);
            for (int i = 0; i < st.size(); i++) {
                System.out.println("^^^^^^");
                System.out.println(st.get(i));
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("END SYMBOL TABLE");
        System.out.println("----------------------------------------------------");
    }

    public int getLastElementPos() {
        return scopes.get(scopes.size() - 1).size() - 1;
    }

    public symbolTableEntry getLastElement(int pos) {
        return scopes.get(scopes.size() - 1).get(pos);
    }


    public symbolTableEntry lookupWithScope(String name) {
        if (scopes.isEmpty()) {
            return null;
        }
        // System.out.println(scopes.size());
        for (int i = scopes.size() - 1; i >= 0; i--) {
            //    System.out.println(i);
            Stack latestScope = scopes.get(i);
            if (latestScope.isEmpty()) {
                continue;
            }
            for (int j = latestScope.size() - 1; j >= 0; j--) {
                symbolTableEntry temp = (symbolTableEntry) latestScope.get(j);
                if (name.equals(temp.getId())) {
                    return temp;
                }
            }
        }
        return null;

    }

    public int exit() {
        System.out.println("exiting scope " + (scopes.size() - 1));
        scopes.remove(scopes.size() - 1);
        //System.out.println("scopes" + scopes.size());

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
