package com.compilers;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Windows 8 on 26-Jun-17.
 */
public class finalCode {

    int label;

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
        Integer place = 1;
        place = varLocations.get(a);
        if(place == null){
            place =1;
        }
        return "mov " + R + ", byte ptr [bp + " + (2 * place) + "]";
    }

    public String load(String R, String a, int mode) {
        String ret;
        Integer place;
        switch (mode) {

            case 1:
                ret = getAR(a);
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret += "\nmov " + R + ", byte ptr [si + " + (2 * place) + "]";
                break;
            case 2:
                ret = getAR(a);
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret += "mov " + "si" + ", word ptr [si + " + (2 * place) + "]\n";
                ret += "mov " + R + ", byte ptr [si]";
                break;
            case 3:
                ret = load("di", a);
                ret += "\nmov " + R + ", byte ptr [di]";
                break;
            case 4:
                ret = loadAdrr(R, a, 1);
                break;
            default:
                ret = "f..k dat";
                break;
        }
        return ret;
    }

    public String loadAdrr(String R, String a, int mode) {
        String ret;
        Integer place;
        switch (mode) {
            case 1:
                ret = "lea" + R + " byte ptr " + a;
                break;
            case 2:
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret = "lea " + R + ", byte ptr [bp + " + (2 * place) + "]";
                break;
            case 3:
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret = "mov " + R + ", word ptr [bp + " + (2 * place) + "]";
                break;
            case 4:
                ret = getAR(a);
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret += "\nlea " + R + ", byte ptr [si + " + (2 * place) + "]";
                break;
            case 5:
                ret = getAR(a);
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret += "\nmov " + R + ", byte ptr [si + " + (2 * place) + "]";
                break;
            case 6:
                ret = load("di", a);
                ret += "\nlea " + R + ", byte ptr [di]";
                break;
            default:
                ret = "lol nope";
                break;
        }
        return ret;
    }

    public String store(String R, String a, int mode) {
        String ret;
        Integer place;
        switch (mode) {
            case 1:
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret = "mov byte ptr [bp + " + (2 * place) + "] " + R;
                break;
            case 2:
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret = "mov si, word ptr [bp + " + (2 * place) + "]\n" + "move byte ptr [si], " + R;
                break;
            case 3:
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret = getAR(a);
                ret = "mov byte ptr [si + " + (2 * place) + "], " + R;
                break;
            case 4:
                ret = getAR(a);
                place = varLocations.get(a);
                if(place==null){
                    place = 1;
                }
                ret += "\nmov si, word ptr [si + " + (2 * place) + "]" + " \nmov byte ptr [si]," + R;
                break;
            default:
                ret = "lol nope";
                break;
        }
        return ret;
    }

    public String getAR(String a) {
        int varScope = symbolTable.getVariableScope(a);
        int curScope = symbolTable.getScopes().size();

        String ret = "mov si , word ptr[bp + 4]";
        if (curScope - varScope > 1) {
            int temp = curScope - varScope;
            while (temp > 1) {
                ret += "\n" +
                        "mov si , word ptr[si + 4]";
                temp--;
            }
        }
        return ret;
    }


    public finalCode(Map<String, Integer> varLocations, Map<String, String> stringLiteral) {
        this.varLocations = varLocations;
        this.stringLiteral = stringLiteral;
    }

    public finalCode(Map<String, Integer> varLocations, Map<String, String> stringLiteral, SymbolTable symbolTable) {
        this.varLocations = varLocations;
        this.stringLiteral = stringLiteral;
        this.symbolTable = symbolTable;
        this.label = 0;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int nextLabel() {
        return this.label++;
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

    public String updateAL(){
        return "push bp";
    }

    public void genFinalCode(Quads quad, PrintWriter writer) {
        switch (quad.getOp()) {
            case "unit":
                writer.println("_" + quad.getArg1() + "_ proc near");
                writer.println("push bp");
                writer.println("mov bp, sp");
                writer.println("sub sp, 8");
                break;
            case "endu":
                writer.println("mov sp, bp");
                writer.println("pop bp");
                writer.println("ret");
                writer.println("_" + quad.getArg1() + "_ endp");
                break;
            case "+":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("add ax, dx");
                writer.println(store("ax", quad.getRet().toString().trim(), 1));
                break;
            case "-":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("sub ax, dx");
                writer.println(store("ax", quad.getRet().toString().trim(), 1));
                break;
            case "*":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("imul cx");
                writer.println(store("ax", quad.getRet().toString().trim(), 1));
                break;
            case "/":
                writer.println(load("ax", quad.getArg1()));
                writer.println("cwd");
                writer.println(load("dx", quad.getArg2()));
                writer.println("idiv cx");
                writer.println(store("ax", quad.getRet().toString().trim(), 1));
                break;
            case "%":
                writer.println(load("ax", quad.getArg1()));
                writer.println("cwd");
                writer.println(load("dx", quad.getArg2()));
                writer.println("idiv cx");
                writer.println(store("dx", quad.getRet().toString().trim(), 1));
                break;
            case ":=":
                writer.println(load("ax", quad.getArg1()));
                writer.println(store("ax", quad.getRet().toString().trim(),1));
                break;
            case "array":
                writer.println(load("ax", quad.getArg2()));
                writer.println("mov cx, size");
                writer.println("imul cx");
                writer.println(loadAdrr("cx", quad.getArg1(),1));
                writer.println("add ax, cx");
                writer.println(store("ax", quad.getRet().toString().trim(),1));
                break;
            case "<":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("jl " + quad.getRet().toString().trim());
                break;
            case ">":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("jg " + quad.getRet().toString().trim());
                break;
            case "<=":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("jle " + quad.getRet().toString().trim());
                break;
            case ">=":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("jge " + quad.getRet().toString().trim());
                break;
            case "=":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("je " + quad.getRet().toString().trim());
                break;
            case "!=":
                writer.println(load("ax", quad.getArg1()));
                writer.println(load("dx", quad.getArg2()));
                writer.println("cmp ax, dx");
                writer.println("jne " + quad.getRet().toString().trim());
                break;
            case "ifb":
                writer.println(load("al", quad.getArg1()));
                writer.println("or al, al");
                writer.println("jnz " + quad.getRet().toString().trim());
                break;
            case "jump":
                writer.println("jnz " + quad.getArg1());
                break;
            case "label":
                writer.println(nextLabel());
            case "jumpl":
                writer.println("jnz " + quad.getArg1());
                break;
            case "call":
                writer.println("sub sp, 2");
                writer.println(updateAL());
                writer.println("call near ptr "+quad.getArg1());
                writer.println("add sp, 8+4");
                break;
            case "par":
                switch (quad.getArg2()){
                    case "VAR":
                        writer.println(load("ax",quad.getArg1()));
                        writer.println("push ax");
                        break;
                    case "REF":
                        writer.println(loadAdrr("si",quad.getArg1(),1));
                        writer.println("push si");
                        break;
                    default:
                        writer.println(loadAdrr("si",quad.getArg1(),3));
                        writer.println("push si");
                        break;
                }
                break;
            case "ret":
                writer.println("sub sp, 2");
                writer.println(updateAL());
                writer.println("call near ptr "+quad.getArg1());
                writer.println("add sp, 8+4");
                break;
            case "default":
                break;
        }
    }
}
