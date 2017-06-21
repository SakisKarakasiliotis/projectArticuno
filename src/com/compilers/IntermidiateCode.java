package com.compilers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Windows 8 on 21-Jun-17.
 */
public class IntermidiateCode {
    private List<Quads> quads;

    private int temp;

    public IntermidiateCode() {
        this.quads = new LinkedList<>();
        this.temp = 0;
    }

    public IntermidiateCode(List<Quads> quads) {
        this.quads = new LinkedList<>();
        this.quads = quads;
        this.temp = 0;
    }

    public List<Quads> getQuads() {
        return quads;
    }

    public void setQuads(List<Quads> quads) {
        this.quads = quads;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "IntermidiateCode{" +
                "quads=" + quads +
                '}';
    }

    public void genQuad(Quads.Operand op, String arg1, String arg2, boolean ret) {
        int label = quads.size();
        String retReg = "-";
        if (ret) {
            retReg = "$" + temp;
            temp++;
        }
        if (arg1.equals("")) {
            arg1 = "-";
        }
        if (arg2.equals("")) {
            arg2 = "-";
        }
        String operand = Quads.Operand.operand.getOperand(op);
        Quads q = new Quads(label, operand, arg1, arg2, retReg);
        this.quads.add(q);
    }

    public int nextQuad(){
        return quads.size();
    }
}
