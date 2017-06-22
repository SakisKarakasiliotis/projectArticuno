package com.compilers;

import java.util.*;


public class IntermidiateCode {

    private List<Quads> quads;

    private List<Integer> trueList;

    private List<Integer> falseList;

    private Stack<List<Quads>> nextStack = new Stack<>();

    private int temp;

    public IntermidiateCode() {
        this.quads = new LinkedList<>();
        trueList = new LinkedList<>();
        falseList = new LinkedList<>();

        this.temp = 0;
    }

    public IntermidiateCode(List<Quads> quads) {
        this.quads = new LinkedList<>();
        trueList = new LinkedList<>();
        falseList = new LinkedList<>();
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

    public List<Integer> getTrueList() {
        return trueList;
    }

    public void setTrueList(List<Integer> trueList) {
        this.trueList = trueList;
    }

    public List<Integer> getFalseList() {
        return falseList;
    }

    public void setFalseList(List<Integer> falseList) {
        this.falseList = falseList;
    }

    public int getTrueListSize() {
        return trueList.size();
    }

    public void addTrueList(int x) {
        this.trueList.add(new Integer(x));
    }

    public int getFalseListSize() {
        return falseList.size();
    }

    public void addFalseList(int x) {
        this.falseList.add(new Integer(x));
    }

    @Override
    public String toString() {
        return "IntermidiateCode{" +
                "quads=" + quads +
                '}';
    }

    public void genQuad(Quads.Operand op, String arg1, String arg2, int ret) {
        int label = quads.size();
        String retReg = "-";
        if (ret!=-1) {
            retReg = "$" + ret;
        }
        if (arg1.equals("")) {
            arg1 = "-";
        }
        if (arg2.equals("")) {
            arg2 = "-";
        }
        String operand = Quads.Operand.operand.getOperand(op);
        Quads q = new Quads(label, operand, arg1, arg2, retReg);
        this.nextStack.get(nextStack.size()-1).add(q);
    }

    public int nextQuad() {
        return quads.size();
    }

    public int newTemp() {
        return ++temp;
    }

    public void newList(){
        nextStack.push(new LinkedList<Quads>());
    }

    public void merge(){
         List<Quads> toBeMerged = nextStack.pop();
         String name = toBeMerged.get(0).getArg1();
         genQuad(Quads.Operand.ENDU,name,"-",-1);
         int size=quads.size();
        for (Quads q: toBeMerged) {
            q.setLabel(q.getLabel()+size);
            quads.add(q);
        }
        String operand = Quads.Operand.operand.getOperand(Quads.Operand.ENDU);
        quads.add(new Quads(quads.size(),operand,name,"-","-"));
    }
}
