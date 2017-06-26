package com.compilers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Windows 8 on 26-Jun-17.
 */
public class finalCode {

    Map<String, Integer> varLocations;

    Map<String, String> stringLiteral;

    SymbolTable symbolTable;

    public String load(String R, int a) {
        return "mov " + R + ", " + a;
    }

    public String load(String R, boolean a) {
        return a ? "mov " + R + ", 1" : "mov " + R + ", 0";
    }

    public String load(String R, char a) {
        return "mov " + R + ", ASCII(" + a + ")";
    }

    public String load(String R) {
        return "mov " + R + ", 0";
    }

    public String load(String R, String a) {
        int place = varLocations.get(a);
        return "mov " + R + ", byte ptr [bp + " + (2 * place) + "]";
    }



    public finalCode(Map<String, Integer> varLocations, Map<String, String> stringLiteral) {
        this.varLocations = varLocations;
        this.stringLiteral = stringLiteral;
    }

    public finalCode(Map<String, Integer> varLocations, Map<String, String> stringLiteral, SymbolTable symbolTable) {
        this.varLocations = varLocations;
        this.stringLiteral = stringLiteral;
        this.symbolTable = symbolTable;
    }

    public Map<String, Integer> getVarLocations() {
        return varLocations;
    }

    public void setVarLocations(Map<String, Integer> varLocations) {
        this.varLocations = varLocations;
    }

    public Map<String, String> getStringLiteral() {
        return stringLiteral;
    }

    public void setStringLiteral(Map<String, String> stringLiteral) {
        this.stringLiteral = stringLiteral;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
}
