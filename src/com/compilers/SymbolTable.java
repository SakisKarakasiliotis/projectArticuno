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



    public void enter() {
        scopes.add(new Stack<symbolTableEntry>());
        loadLibraries();
    }

    public int insert(String name, EntryType type, EntryType parent) {
        name = name.trim();
        Stack latestScope = scopes.get(scopes.size() - 1);

        symbolTableEntry symbolTableEntry = new symbolTableEntry(name, type, parent);
        latestScope.push(symbolTableEntry);

        return 0;
    }

    public int insert(symbolTableEntry input) {
        input.setId(input.getId().trim());
        Stack latestScope = scopes.get(scopes.size() - 1);

        latestScope.push(input);
        return 0;
    }

    public int insertToParent(String name, EntryType type, EntryType parent) {
        name = name.trim();
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
        input.setId(input.getId().trim());
        Stack latestScope;
        if (scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        } else {
            latestScope = scopes.get(scopes.size() - 1);
        }
        latestScope.push(input);
        return 0;
    }


    public symbolTableEntry getFunctionEntry() {
        Stack latestScope;

        if (scopes.size() > 1) {
            latestScope = scopes.get(scopes.size() - 2);
        } else {
            latestScope = scopes.get(scopes.size() - 1);
        }
//        while (!latestScope.isEmpty()) {
//            symbolTableEntry temp = (symbolTableEntry) latestScope.pop();
//            if (temp.getType().equals(EntryType.FUNC_NAME) && temp.getParent().equals(EntryType.FUNC_DEF)) {
//                return temp;
//            }
//        }
        for (int i =latestScope.size()-1; i >= 0 ; i--) {
            symbolTableEntry temp = (symbolTableEntry) latestScope.get(i);
            if (temp.getType().equals(EntryType.FUNC_NAME) && temp.getParent().equals(EntryType.FUNC_DEF)) {
                return temp;
            }
        }
        return null;

    }

    public symbolTableEntry lookup(String name, EntryType type) {
        name = name.trim();
        for (Stack latestScope : scopes) {
            for (int i = latestScope.size() - 1; i >= 0; i--) {
                symbolTableEntry temp = (symbolTableEntry) latestScope.get(i);
                if (name.equals(temp.getId())) {
                    return temp;
                } else if (temp.getType().equals(EntryType.FUNC_NAME)) {
                    for (symbolTableEntry a : temp.getfParams()) {
                        if (a.getId().equals(name)) {
                            return a;
                        }
                    }
                }
            }
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




    public symbolTableEntry lookupWithScope(String name) {
        if (scopes.isEmpty()) {
            return null;
        }
        for (int i = scopes.size() - 1; i >= 0; i--) {
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
        scopes.remove(scopes.size() - 1);
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
            for (int i = 0; i < names.length; i++) {
                symbolTableEntry s = new symbolTableEntry(names[i], EntryType.LIBRARY_FUNCTION, EntryType.FUNC_DEF);
                s.setRetType(returns[i]);
                List<symbolTableEntry> fParams = new LinkedList<>();
                for (int j = 0; j < params[i].length; j++) {
                    symbolTableEntry temp = new symbolTableEntry(params[i][j], EntryType.FUNC_PARAM, EntryType.FUNC_DEF);
                    temp.setRetType(paramtype[i][j]);
                    temp.setfParType(paramtype[i][j]);
                    if(!names[i].equals("geti") && !names[i].equals("getc")){
                        fParams.add(temp);
                    }

                }
                s.setfParams(fParams);
                Stack latestScope = scopes.get(0);
                latestScope.push(s);
            }
        }
    }

    public int getVariableScope(String id){
        if (scopes.isEmpty()) {
            return -1;
        }
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Stack latestScope = scopes.get(i);
            if (latestScope.isEmpty()) {
                continue;
            }
            for (int j = latestScope.size() - 1; j >= 0; j--) {
                symbolTableEntry temp = (symbolTableEntry) latestScope.get(j);
                if (id.equals(temp.getId())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
